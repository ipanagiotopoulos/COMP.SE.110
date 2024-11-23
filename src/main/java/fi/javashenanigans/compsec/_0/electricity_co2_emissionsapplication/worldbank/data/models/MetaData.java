package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.data.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @NoArgsConstructor
public class MetaData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceid;

    private int page;
    private int pages;
    private int perPage;
    private int total;
    private String lastUpdated;


}
