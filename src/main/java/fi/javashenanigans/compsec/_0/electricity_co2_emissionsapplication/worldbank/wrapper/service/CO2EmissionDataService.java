package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.helpers.IndicatorsTranslatorService;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.models.EmissionResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service.config.WorldBankConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Automatically generates a constructor for required fields
public class CO2EmissionDataService {
    private final WorldBankConfig worldBankConfig;

    public  CO2EmissionDataService(){
        worldBankConfig = new WorldBankConfig();
    }


    public EmissionResponse getStats( List <String> entities, List<IndicatorsTranslatorService.Indicators> indicators, int startDate, int endDate) {
        System.out.println("hereeee"+this.worldBankConfig.getApiVersion());
        CO2EmissionsDataCallerApiClient client = new CO2EmissionsDataCallerApiClient(worldBankConfig);
        return client.fetchCO2EmissionsData(entities, List.of(startDate, endDate),indicators);
    }
}
