package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.service;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.helpers.EmberSeries;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models.EnergyResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.wrapper.ember.service.config.EmberConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmberDataService {
    @Autowired
    private  EmberConfigService emberConfigService = new EmberConfigService();

    public EnergyResponse getStats( List<String> entities, List <EmberSeries> series, int startDate, int endDate) {
        System.out.println(emberConfigService.getBaseUrl());
        EmberStatsCallerApiClient client = new EmberStatsCallerApiClient(emberConfigService);
        return client.fetchEnergyData(entities, series, List.of(startDate, endDate));
    }
}
