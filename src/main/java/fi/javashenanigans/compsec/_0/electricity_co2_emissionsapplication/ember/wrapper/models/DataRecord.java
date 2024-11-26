package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models;



import lombok.*;

@Getter @Setter @AllArgsConstructor @ToString
public class DataRecord {
    private String entity;
    private String entity_code;
    private boolean is_aggregate_entity;
    private String date;
    private String series;
    private boolean is_aggregate_series;
    private double generation_twh;
    private double share_of_generation_pct;

}