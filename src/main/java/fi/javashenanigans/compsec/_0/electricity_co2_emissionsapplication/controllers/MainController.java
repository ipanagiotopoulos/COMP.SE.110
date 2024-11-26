package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.controllers;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.ResponseDTO;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.service.EmberDataService;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.handlers.APIsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
        return apisHandlerService.getDataFromBothSources(dateRange, countries, series, indicators)
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