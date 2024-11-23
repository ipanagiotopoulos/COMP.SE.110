package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.data.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DataRecord {
    @Id
    @GeneratedValue
    private Long id;

    private String entity;
    private String entityCode;
    private boolean isAggregateEntity;
    private String date;
    private String series;
    private boolean isAggregateSeries;
    private double generationTwh;
    private double shareOfGenerationPct;

}