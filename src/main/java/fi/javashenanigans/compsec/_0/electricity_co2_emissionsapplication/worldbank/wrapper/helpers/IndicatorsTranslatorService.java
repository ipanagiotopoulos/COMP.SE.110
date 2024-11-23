package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.helpers;

public class IndicatorsTranslatorService {

    public String enumToIndicatorCodes(Indicators indicator) throws IllegalArgumentException{
        switch (indicator){
            case methane-> {return "EN.GHG.CH4.ZG.AR5";}
            case co2_emissions -> {return "EN.GHG.CO2.ZG.AR5";}
            case co2_intensity -> {return "EN.GHG.CO2.RT.GDP.PP.KD";}
            case nitrous_oxide -> {return "EN.GHG.N2O.ZG.AR5";}
            default->throw new IllegalArgumentException();
        }
    }


    public enum Indicators{
        methane,
        nitrous_oxide,
        co2_intensity,
        co2_emissions
    }
}
