package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.helpers.RequestParamsHandler;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.helpers.IndicatorsTranslatorService;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.models.EmissionResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service.config.WorldBankConfig;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

@Service
public class CO2EmissionsDataCallerApiClient {

    private final CO2EmissionService apiService;

    public CO2EmissionsDataCallerApiClient(WorldBankConfig worldBankConfig) {
        String baseUrl = constructUrl(
                worldBankConfig.getBaseUrl(),
                worldBankConfig.getApiVersion(),
                worldBankConfig.getPrefix()
        );
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.apiService = retrofit.create(CO2EmissionService.class);
    }

    public EmissionResponse fetchCO2EmissionsData(
            List<String> countries,
            List<Integer> dateRange,
            List<IndicatorsTranslatorService.Indicators> indicators
    ) {
        Call<EmissionResponse> call = apiService.getCO2EmissionsData(
                9999, // Example query parameter (replace as needed)
                RequestParamsHandler.DateRangeToString(dateRange),
                "json"
        );

        try {
            Response<EmissionResponse> response = call.execute(); // Synchronous call
            if (response.isSuccessful() && response.body() != null) {
                EmissionResponse emissionsData = response.body();
                System.out.println("Fetched CO2 emissions data: " + emissionsData);
                return emissionsData;
            } else {
                System.err.println("Request failed. Error: " + response.errorBody().string());
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error while fetching CO2 emissions data: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private String constructUrl(String baseUrl, String apiVersion, String prefix) {
        return String.format("%s%s/%s/", baseUrl, apiVersion, prefix);
    }
}
