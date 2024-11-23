package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.data.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter @Setter @NoArgsConstructor
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timestamp;
    private double responseTimeInSeconds;
    private String rateLimit;
    private int numberOfRecords;
    @OneToOne
    private QueryParametersUsed queryParametersUsed;
    @ElementCollection
    private List <String> availableMetrics;
    @OneToOne
    private QueryValueRange queryValueRange;
    private String queryAllDatesValueRange;


    @Entity
    @Getter @Setter @NoArgsConstructor
    class QueryParametersUsed {
        @ElementCollection
        private List<String> entity;
        private String startDate;
        private String endDate;
        @ElementCollection
        private List<String> series;
        private boolean isAggregateSeries;
        @Id
        @GeneratedValue
        private Long id;
    }

    @Entity
    @Getter @Setter @NoArgsConstructor
    class QueryValueRange {
        @OneToOne
        private MetricRangeDAO generationTwh;
        @OneToOne
        private MetricRangeDAO shareOfGenerationPct;
        @Id
        @GeneratedValue
        private Long id;
    }

    @Entity
    @Getter @Setter @NoArgsConstructor
    class MetricRangeDAO {
        private double min;
        private double max;
        @Id
        @GeneratedValue
        private Long id;

    }

}


