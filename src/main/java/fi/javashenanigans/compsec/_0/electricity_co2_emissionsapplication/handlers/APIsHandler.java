package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.handlers;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.ResponseDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.DataDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.searchdescription.SearchDescriptionDTO;
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

    public ResponseDTO getDataFromBothSources(String dateRange, String countries, String series, String indicatorList){

        List <Integer> dates = RequestParamsHandler.StringToDateRange(dateRange);
        List <EmberSeries> emberSeries = RequestParamsHandler.StringToEmberSeries(series);
        List < IndicatorsTranslatorService.Indicators> indicators = RequestParamsHandler.StringToIndicators(indicatorList);
        List <String> countryList = Arrays.stream(countries.split(",")).toList();

        SearchDescriptionBuilder searchDescriptionBuilder = new SearchDescriptionBuilder();
        SearchDescriptionDTO search = searchDescriptionBuilder.BuildSearchDescription(countryList,dates);


        DataDTO dataDTO =  new DataDTO();


        co2EmissionService.getStats(countryList, indicators, dates.get(0), dates.get(1));
        electricityGenerationDataService.getStats(countryList, emberSeries, dates.get(0), dates.get(1));

    }


}
