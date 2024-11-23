package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public class EmissionData {
    private String countryiso3code;
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



