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


@Component
public class ElectricityGenerationStatsCallerApiClient {

    private final ElectricityGenerationService apiService;
    private final EmberConfigService emberConfigService;


    @Autowired
    public ElectricityGenerationStatsCallerApiClient( EmberConfigService emberConfigService ) {
        this.emberConfigService = emberConfigService;
        String baseUrl = constructUrl(this.emberConfigService.getBaseUrl( ), this.emberConfigService.getApiVersion());
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create( )).build( );
        this.apiService = retrofit.create(ElectricityGenerationService.class);
    }

    public EnergyResponse fetchEnergyData( List<String> countries, List <EmberSeries> seriesList, List<Integer> dateRange) {

        Call <EnergyResponse> call = apiService.getElectricityGenerationStat(countries.toString(), seriesList.toString(), true, dateRange.get(0).toString(), dateRange.get(1).toString(),emberConfigService.getApiKey());


        try{
            Response <EnergyResponse> response = call.execute();
            if ( response.isSuccessful( ) ) {
                EnergyResponse energyStatsData = response.body();

                System.out.println("Fetched energy data: " + energyStatsData.toString());
                return energyStatsData;
            } else {
                System.err.println("Request failed. Error: " + response.errorBody().string() + " whole body" + response.body( ));
                return null;
            }

        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private String constructUrl( String baseUrl , String apiVersion) {
        return baseUrl + apiVersion + "/";
    }
}

