package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.Ember;


import lombok.*;

@Getter
@Setter @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CarbonIntensityDTO implements EmberDataDTO {
    private int emissionsIntensityGco2PerKwh;
}
