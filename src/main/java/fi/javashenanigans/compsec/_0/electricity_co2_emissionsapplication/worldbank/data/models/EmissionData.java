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
public class EmissionData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String countryiso3code;  // Using countryiso3code as a unique identifier
    private String indicatorId;
    private String indicatorValue;
    private String countryId;
    private String countryValue;
    private String date;
    private double value;
    private String unit;
    private String obsStatus;
    private int decimal;



}



