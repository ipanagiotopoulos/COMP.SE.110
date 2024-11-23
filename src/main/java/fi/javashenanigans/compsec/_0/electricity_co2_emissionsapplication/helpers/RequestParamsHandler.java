package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.helpers;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.helpers.EmberSeries;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.helpers.IndicatorsTranslatorService;

import java.util.ArrayList;
import java.util.List;

public  class RequestParamsHandler {

    public static List<EmberSeries> StringToEmberSeries( String seriesRequestParams){
        String[] seriesList = seriesRequestParams.split(",");
        List<EmberSeries> series = new ArrayList<>(seriesList.length);
        for(String singleSeries: seriesList){
            series.add(EmberSeries.valueOf(singleSeries));
        }
        return series;
    }

    public static List<IndicatorsTranslatorService.Indicators> StringToIndicators( String indicatorsRequestParams){
        String[] indicatorsList = indicatorsRequestParams.split(",");
        List<IndicatorsTranslatorService.Indicators> indicators = new ArrayList<>(indicatorsList.length);
        for(String indicator: indicatorsList){
            indicators.add(IndicatorsTranslatorService.Indicators.valueOf(indicator));
        }
        return indicators;
    }

    public static List<Integer> StringToDateRange( String dateRange){
        String[] dateList = dateRange.split(":");
        List<Integer> dates = new ArrayList<>(dateList.length);
        for (int i = 0; i < 2; i++) {
            dates.add(Integer.parseInt(dateList[i]));
        }
        return dates;
    }

    public static String EmberSeriesToString(List<EmberSeries> series) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < series.size(); i++) {
            result.append(series.get(i).name());
            if (i < series.size() - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }

    public static String IndicatorsToString(List<IndicatorsTranslatorService.Indicators> indicators) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < indicators.size(); i++) {
            result.append(indicators.get(i).name());
            if (i < indicators.size() - 1) {
                result.append(",");
            }
        }
        return result.toString();
    }

    public static String DateRangeToString(List<Integer> dateRange) {
        if (dateRange.size() != 2) {
            throw new IllegalArgumentException("Date range must contain exactly two integers.");
        }
        return dateRange.get(0) + ":" + dateRange.get(1);
    }










}
