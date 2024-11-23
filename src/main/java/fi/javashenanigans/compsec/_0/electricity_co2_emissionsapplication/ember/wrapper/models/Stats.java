package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.wrapper.ember.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter @Setter @NoArgsConstructor@ToString
public class Stats {
    private Long id;

    private String timestamp;
    private double responseTimeInSeconds;
    private String rateLimit;
    private int numberOfRecords;
    private QueryParametersUsed queryParametersUsed;
    private List <String> availableMetrics;
    private QueryValueRange queryValueRange;
    private String queryAllDatesValueRange;


    @Getter @Setter @NoArgsConstructor
    class QueryParametersUsed {
        private List<String> entity;
        private String startDate;
        private String endDate;
        private List<String> series;
        private boolean isAggregateSeries;
        private Long id;
    }

    @Getter @Setter @NoArgsConstructor
    class QueryValueRange {
        private MetricRangeDAO generationTwh;
        private MetricRangeDAO shareOfGenerationPct;
        private Long id;
    }

    @Getter @Setter @NoArgsConstructor
    class MetricRangeDAO {
        private double min;
        private double max;
        private Long id;
    }

}


