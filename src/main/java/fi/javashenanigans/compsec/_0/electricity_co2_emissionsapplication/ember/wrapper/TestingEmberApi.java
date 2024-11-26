package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.helpers.EmberSeries;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models.EnergyResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.service.EmberDataService;

import java.util.ArrayList;
import java.util.List;

public class TestingEmberApi {

    public static void main(String[] args) {

        EmberDataService emberDataService = new EmberDataService();

        List <String> countries = new ArrayList<String>();
        countries.add("FI");
        countries.add("US");

        List<EmberSeries> emberSeries =  new ArrayList<EmberSeries>();
        emberSeries.add(EmberSeries.bioenergy);
        emberSeries.add(EmberSeries.wind);
        int startDate = 1980;
        int endDate = 1981;
        EnergyResponse emberResponse = emberDataService.getStats(countries,emberSeries, startDate, endDate);
        System.out.println("response is"+emberResponse.toString());
    }
}
