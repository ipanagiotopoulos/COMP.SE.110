package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.service;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models.EnergyResponse;
import retrofit2.Call;
import retrofit2.http.Query;
import retrofit2.http.GET;

public interface EmberService {

    @GET("/v1/electricity-generation/yearly")
    Call <EnergyResponse> getElectricityGenerationStat( @Query("entity") String entity,
                                                        @Query("series") String emberSeriesList,
                                                        @Query("includes_all_dates_values_range") boolean includesAllDatesValueRange,
                                                        @Query("start_date") String startDate,
                                                        @Query("end_date") String endDate,
                                                        @Query("api_key") String apiKey);
    @GET("/v1/power-sector-emissions/yearly")
    Call<EnergyResponse> getPowerSectorEmissions( @Query("entity") String entity,
                                         @Query("series") String emberSeriesList,
                                         @Query("includes_all_dates_values_range") boolean includesAllDatesValueRange,
                                         @Query("start_date") String startDate,
                                         @Query("end_date") String endDate,
                                         @Query("api_key") String apiKey);

    @GET("/v1/electricity-demand/yearly")
    Call<EnergyResponse> getElectricityDemand( @Query("entity") String entity,
                                         @Query("series") String emberSeriesList,
                                         @Query("includes_all_dates_values_range") boolean includesAllDatesValueRange,
                                         @Query("start_date") String startDate,
                                         @Query("end_date") String endDate,
                                         @Query("api_key") String apiKey);
    @GET("/v1/electricity-demand/yearly")
    Call<EnergyResponse> getElectricityDemand( @Query("series") String emberSeriesList,
                                               @Query("includes_all_dates_values_range") boolean includesAllDatesValueRange,
                                               @Query("start_date") String startDate,
                                               @Query("end_date") String endDate,
                                               @Query("api_key") String apiKey);


}
