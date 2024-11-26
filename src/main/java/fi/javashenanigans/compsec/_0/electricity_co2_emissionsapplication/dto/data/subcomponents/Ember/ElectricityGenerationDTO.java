package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.Ember;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@Builder
public class ElectricityGenerationDTO implements EmberDataDTO {
    private String series;
    private double generationTwh;
    private  double shareOfElectricityGeneration;
}



