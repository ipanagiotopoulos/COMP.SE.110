package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.*;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.Ember.EmberDataDTO;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class DataDTO {
    private String countryIso3Code;
    private String country;
    private String region;
    private String date;
    private EmissionDTO emissions;

    //those are based on the urls
    private EmberDataDTO emberData;
}
