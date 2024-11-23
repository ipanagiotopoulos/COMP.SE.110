package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor
public class DataDTO {
    private String countryIso3Code;
    private String country;
    private String region;
    private String date;
    private EmissionDTO emissions;

    //those are based on the urls
    private CarbonIntensityDTO carbonIntensity;
    private ElectricityGenerationDTO electricityGeneration;
    private ElectricityDemandDTO electricityDemand;
    private PowerSectorEmissionsDTO powerSectorEmissions;
}
