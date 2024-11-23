package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models.EnergyResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.helpers.RequestParamsHandler;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.helpers.IndicatorsTranslatorService;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.models.EmissionData;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.models.EmissionResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service.config.WorldBankConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.  converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

import java.util.List;


@Service
public class CO2EmissionsDataCallerApiClient {

    private  CO2EmissionService apiService;
    private WorldBankConfigService worldBankConfigService;


    @Autowired
    public CO2EmissionsDataCallerApiClient( WorldBankConfigService worldBankConfigService ) {
        this.worldBankConfigService = worldBankConfigService;
        String baseUrl = constructUrl(worldBankConfigService.getBaseUrl(), worldBankConfigService.getApiVersion(),worldBankConfigService.getPrefix());
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        this.apiService = retrofit.create(CO2EmissionService.class);
    }


   // replace void
    public EmissionResponse fetchco2EmissionsData( List <String> countries, List<Integer> dateRange, List<IndicatorsTranslatorService.Indicators> indicators ) {
        Call <EmissionResponse> call = apiService.getCO2EmissionsData(9999, RequestParamsHandler.DateRangeToString(dateRange),"json");
        try {
            Response <EmissionResponse> emissionResponse = call.execute();////// Synchronous call
            if ( emissionResponse.isSuccessful( ) ) {
                EmissionResponse emissionsData = emissionResponse.body();
                System.out.println("Fetched energy data: " + emissionsData.toString());
                return emissionsData;
            } else {
                System.err.println("Request failed. Error: " + emissionResponse.errorBody().string() +" whole body"+emissionResponse.body());
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }


    private String constructUrl( String baseUrl ,String apiVersion, String prefix) {
        return baseUrl + apiVersion + "/"+prefix+"/";
    }
}
