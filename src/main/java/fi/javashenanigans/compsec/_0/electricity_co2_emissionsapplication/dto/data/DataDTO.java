package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.*;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.Ember.EmberData;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.Ember.EmberDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class DataDTO {
    private String countryIso3Code;
    private String country;
    private String region;
    private String date;
    private EmissionDTO emissions;

    //those are based on the urls
    private EmberDataDTO emberData;
}
