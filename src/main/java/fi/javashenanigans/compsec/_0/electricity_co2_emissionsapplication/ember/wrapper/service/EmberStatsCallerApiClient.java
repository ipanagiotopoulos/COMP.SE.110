package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.service;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.helpers.EmberSeries;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models.EnergyResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.wrapper.ember.service.config.EmberConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.  converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EmberStatsCallerApiClient {

    private final EmberService apiService;
    private final EmberConfigService emberConfigService;


    @Autowired
    public EmberStatsCallerApiClient( EmberConfigService emberConfigService ) {
        this.emberConfigService = emberConfigService;
        String baseUrl = constructUrl(this.emberConfigService.getBaseUrl( ), this.emberConfigService.getApiVersion());
        System.out.println("base url:" + baseUrl);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        this.apiService = retrofit.create(EmberService.class);
    }

    public EnergyResponse fetchEnergyData( List<String> countries, List <EmberSeries> seriesList, List<Integer> dateRange) {

        String seriesQueryParamString = emberSeriesListToCommaSeparatedString(seriesList);
        String countriesQueryParamString = countriesToCommaSeparatedString(countries);

        Call <EnergyResponse> call = apiService.getElectricityGenerationStat(countriesQueryParamString, seriesQueryParamString, true, dateRange.get(0).toString(), dateRange.get(1).toString(),emberConfigService.getApiKey());
        Response <EnergyResponse> response =null;
        try{
          response = call.execute();
            if ( response.isSuccessful() ) {
                System.out.println("Request succeeded. Url: "+response.raw().request().url());
                System.out.println("Request succeeded. HTTP Status code: "+response.raw().code());
                EnergyResponse energyStatsData = response.body();
                return energyStatsData;
            } else {
                System.err.println("Request failed. Url: "+response.raw().request().url().toString());
                System.err.println("Request failed. HTTP Status code: "+response.raw().code());
                System.err.println("Request failed. Error: " + response.errorBody().string() + " whole body" + response.raw().body());
                return null;
            }
        }
        catch(Exception e) {
            System.out.println("Something wrong happened while calling this url:"+call.request().url());
            System.out.println("body"+response.raw().toString());
            e.printStackTrace();
            return null;
        }
    }


    private String constructUrl( String baseUrl , String apiVersion) {
        return baseUrl +"/"+ apiVersion + "/";
    }

    private String emberSeriesListToCommaSeparatedString(List<EmberSeries> emberSeries) {
        return emberSeries.stream()
                .map(EmberSeries::name)
                .collect(Collectors.joining(","));
    }

    private String countriesToCommaSeparatedString(List<String> countries) {
        return String.join(",", countries);
    }

}

