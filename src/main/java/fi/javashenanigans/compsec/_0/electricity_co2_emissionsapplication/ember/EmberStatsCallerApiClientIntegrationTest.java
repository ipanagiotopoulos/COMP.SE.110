package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.service;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.helpers.EmberSeries;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models.EnergyResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.wrapper.ember.service.config.EmberConfigService;

import java.util.Arrays;
import java.util.List;

public class EmberStatsCallerApiClientIntegrationTest {
    private EmberStatsCallerApiClient apiClient;
    private EmberConfigService configService;

    public void setUp() {
        // Create a concrete implementation of EmberConfigService
        // Note: Replace these with actual values from your application.properties or environment
        configService = new EmberConfigService() {
            @Override
            public String getBaseUrl() {
                return "https://api.ember-climate.org";
            }

            @Override
            public String getApiVersion() {
                return "v1";
            }

            @Override
            public String getApiKey() {
                // IMPORTANT: Replace with your actual Ember API key
                return "b0e10ae2-d272-4cd2-9564-953990746867";
            }
        };

        apiClient = new EmberStatsCallerApiClient(configService);
    }

    public void testElectricityGenerationDataFetch() {
        setUp();

        // Prepare test parameters
        List<String> countries = Arrays.asList("US", "CN"); // Example countries
        List<EmberSeries> series = Arrays.asList(EmberSeries.wind);
        List<Integer> dateRange = Arrays.asList(2020, 2022);

        // Perform API call
        EnergyResponse response = apiClient.fetchEnergyData(countries, series, dateRange);


        // Validate response
        assert response != null : "Energy response should not be null";

        // Add more specific validations based on your EnergyResponse structure
        System.out.println("Electricity Generation Data Fetch Test: PASSED");
        System.out.println("Received Data: " + response);
    }

    public void testMultipleCountriesDataFetch() {
        setUp();

        // Prepare test parameters with multiple countries
        List<String> countries = Arrays.asList("US", "CN", "IN", "DE", "GB");
        List<EmberSeries> series = Arrays.asList(
                EmberSeries.coal,
                EmberSeries.solar
        );
        List<Integer> dateRange = Arrays.asList(2018, 2022);

        // Perform API call
        EnergyResponse response = apiClient.fetchEnergyData(countries, series, dateRange);

        // Validate response
        assert response != null : "Energy response should not be null for multiple countries";

        System.out.println("Multiple Countries Data Fetch Test: PASSED");
        System.out.println("Received Data: " + response);
    }

    public void testLongTermDataFetch() {
        setUp();

        // Prepare test parameters for a longer time range
        List<String> countries = Arrays.asList("US");
        List<EmberSeries> series = Arrays.asList(EmberSeries.wind);
        List<Integer> dateRange = Arrays.asList(2000, 2022);

        // Perform API call
        EnergyResponse response = apiClient.fetchEnergyData(countries, series, dateRange);

        // Validate response
        assert response != null : "Long-term energy response should not be null";

        System.out.println("Long-Term Data Fetch Test: PASSED");
        System.out.println("Received Data: " + response);
    }

    public void testErrorScenarios() {
        setUp();

        // Test with invalid parameters
        try {
            // Empty countries list
            List<String> countries = Arrays.asList();
            List<EmberSeries> series = Arrays.asList(EmberSeries.coal);
            List<Integer> dateRange = Arrays.asList(2020, 2022);

            EnergyResponse response = apiClient.fetchEnergyData(countries, series, dateRange);

            // If no exception is thrown, ensure response is null
            assert response == null : "Response should be null for invalid input";

            System.out.println("Error Scenario Test: PASSED");
        } catch (Exception e) {
            System.err.println("Error Scenario Test: Unexpected exception");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmberStatsCallerApiClientIntegrationTest test = new EmberStatsCallerApiClientIntegrationTest();

        try {
            test.testElectricityGenerationDataFetch();
            test.testMultipleCountriesDataFetch();
            test.testLongTermDataFetch();
            test.testErrorScenarios();

            System.out.println("All integration tests completed successfully!");
        } catch (AssertionError e) {
            System.err.println("Test failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during testing: ");
            e.printStackTrace();
        }
    }
}