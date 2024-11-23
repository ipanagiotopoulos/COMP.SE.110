package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.controllers;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.ResponseDTO;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.DataDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.searchdescription.SearchDescriptionDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.service.ElectricityGenerationDataService;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.handlers.APIsHandler;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.helpers.IndicatorsTranslatorService;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service.CO2EmissionDataService;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service.CO2EmissionService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Query;


@RestController
public class MainController {


    @Autowired
    private APIsHandler apisHandlerService;

    public MainController() {
        this.apisHandlerService = new APIsHandler();
    }

    @GetMapping("/electricity_generation")
    public ResponseDTO getElectricityGenerationAndEmissions(@RequestParam(value="date_range") String dateRange,
                                                            @RequestParam(value="countries") String countries,
                                                            @RequestParam(value="series") String series,
                                                            @RequestParam(value="indicators") String indicators
    ) {
        return apisHandlerService.getDataFromBothSources(dateRange, countries, series, indicators);
    }

    @GetMapping("/power_sector_emissions")
    public ResponseDTO getPowerSectorEmissionsAndEmissions(@RequestParam(value="date_range") String dateRange,
                                                           @RequestParam(value="countries") String countries,
                                                           @RequestParam(value="indicators") String indicators,
                                                           @RequestParam(value="series") String series) {
        return apisHandlerService.getDataFromBothSources(dateRange, countries, series, indicators);
    }

    @GetMapping("/electricity_demand")
    public ResponseDTO getElectricityDemandAndEmissions(@RequestParam(value="date_range") String dateRange,
                                                        @RequestParam(value="countries") String countries,
                                                        @RequestParam(value="indicators") String indicators,
                                                        @RequestParam(value="series") String series) {
        return apisHandlerService.getDataFromBothSources(dateRange, countries, series, indicators);
    }

    @GetMapping("/carbon_intensity")
    public ResponseDTO getCarbonIntensityAndEmissions(@RequestParam(value="date_range") String dateRange,
                                                      @RequestParam(value="countries") String countries,
                                                      @RequestParam(value="indicators") String indicators,
                                                      @RequestParam(value="series") String series) {
        return apisHandlerService.getDataFromBothSources(dateRange, countries, series, indicators);
    }

}