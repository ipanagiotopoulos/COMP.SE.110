package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models;



import lombok.*;

@Getter @Setter @AllArgsConstructor @ToString
public class DataRecord {
    private String entity;
    private String entityCode;
    private boolean isAggregateEntity;
    private String date;
    private String series;
    private boolean isAggregateSeries;
    private double generationTwh;
    private double shareOfGenerationPct;

}