package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.data.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@Entity
@Getter @Setter @NoArgsConstructor
public class EmissionResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private MetaData metadata;

    @ManyToMany
    private List<EmissionData> data;

}

