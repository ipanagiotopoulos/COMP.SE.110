package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.Ember;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PowerSectorEmissionsDTO implements EmberDataDTO{
    private String series;
    private double emissionMTCo2;
    private double shareOfEmissionsPct;
}
