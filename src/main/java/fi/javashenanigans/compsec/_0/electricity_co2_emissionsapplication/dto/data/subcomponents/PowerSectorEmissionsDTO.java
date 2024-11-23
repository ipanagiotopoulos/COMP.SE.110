package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PowerSectorEmissionsDTO {
    private String series;
    private double emissionMTCo2;
    private double shareOfEmissionsPct;
}
