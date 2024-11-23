package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.helpers.IndicatorsTranslatorService;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service.config.WorldBankConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CO2EmissionDataService {

     @Autowired
     public WorldBankConfigService worldBankConfigService = new WorldBankConfigService();


    public void getStats( List<String> entities, List<IndicatorsTranslatorService.Indicators> indicators, int startDate, int endDate) {
        CO2EmissionsDataCallerApiClient client = new CO2EmissionsDataCallerApiClient(worldBankConfigService);
        client.fetchEco2EmissionsData(entities, List.of(startDate ,endDate),indicators);
    }

}
