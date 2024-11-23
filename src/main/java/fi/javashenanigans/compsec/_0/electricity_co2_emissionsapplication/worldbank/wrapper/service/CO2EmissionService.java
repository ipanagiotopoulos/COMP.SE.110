package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models.EnergyResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface CO2EmissionService {

        @GET("/v2/country/{country_list}/indicator/{indicator_id}")
        Call <EnergyResponse> getCO2EmissionsData( @Query("per_page") int  perPage,
                                                   @Query("date") String dateRange ,
                                                   @Query("format") String dataFormat);
    }
