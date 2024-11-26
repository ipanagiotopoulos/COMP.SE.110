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
    private double response_time_in_seconds;
    private String rate_limit;
    private int number_of_records;
    private QueryParametersUsed query_parameters_used;
    private List <String> available_metrics;
    private QueryValueRange query_value_range;
    private String query_all_dates_value_range;

    @Getter @Setter @NoArgsConstructor @ToString
    class QueryParametersUsed {
        private List<String> entity;
        private String start_date;
        private String end_date;
        private List<String> series;
        private Long id;
    }

    @Getter @Setter @NoArgsConstructor @ToString
    class QueryValueRange {
        private MetricRangeDAO generation_twh;
        private MetricRangeDAO share_of_generation_pct;
    }

    @Getter @Setter @NoArgsConstructor @ToString
    class MetricRangeDAO {
        private double min;
        private double max;
    }
}


