package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElectricityGenerationDTO {
    private String series;
    private double generationTwh;
    private  double shareOfElectricityGeneration;
}



