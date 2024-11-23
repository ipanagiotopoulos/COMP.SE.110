package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;




@Getter @Setter @NoArgsConstructor
public class EmissionResponse {
    private Long id;
    private MetaData metadata;
    private List<EmissionData> data;
}

