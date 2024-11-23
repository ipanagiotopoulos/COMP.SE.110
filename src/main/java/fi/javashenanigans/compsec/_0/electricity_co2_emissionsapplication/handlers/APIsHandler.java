package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.handlers;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.ResponseDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.helpers.EmberSeries;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.service.ElectricityGenerationDataService;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.helpers.RequestParamsHandler;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.helpers.IndicatorsTranslatorService;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service.CO2EmissionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class APIsHandler {

    @Autowired
    private final ElectricityGenerationDataService electricityGenerationDataService;
    @Autowired
    private final CO2EmissionDataService co2EmissionService;

    public APIsHandler() {
        this.electricityGenerationDataService =  new ElectricityGenerationDataService();
        this.co2EmissionService = new CO2EmissionDataService();
    }

// @RequestParam(value="date_range") String dateRange,
// @RequestParam(value="countries") String countries,
// @RequestParam(value="series") String series,
// @RequestParam(value="indicators") String indicators


    public ResponseDTO getDataFromBothSources(String dateRange, String countries, String series, String indicatorList){

        List <Integer> dates = RequestParamsHandler.StringToDateRange(dateRange);
        List <EmberSeries> emberSeries = RequestParamsHandler.StringToEmberSeries(series);
        List < IndicatorsTranslatorService.Indicators> indicators = RequestParamsHandler.StringToIndicators(indicatorList);
        List <String> countryList = Arrays.stream(countries.split(",")).toList();

        co2EmissionService.getStats(countryList, indicators, dates.get(0), dates.get(1));
        electricityGenerationDataService.getStats(countryList, emberSeries, dates.get(0), dates.get(1));


    }


}
