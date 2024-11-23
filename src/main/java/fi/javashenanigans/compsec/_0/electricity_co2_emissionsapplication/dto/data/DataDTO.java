package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.CarbonIntensityDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.ElectricityDemandDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.EmissionDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.PowerSectorEmissionsDTO;
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
    private CarbonIntensityDTO carbonIntensity;
    private EmissionDTO emissions;
    private ElectricityDemandDTO electricityDemand;
    private PowerSectorEmissionsDTO powerSectorEmissions;
}
