package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.Ember;


import lombok.*;

@Getter @Setter @Data @AllArgsConstructor @NoArgsConstructor
public class ElectricityDemandDTO  implements EmberDataDTO{
    private String series;
    private double demandTwh;
    private double demandMwhPerCapita;

}

