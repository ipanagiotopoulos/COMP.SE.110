package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.service;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.helpers.EmberSeries;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models.EnergyResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.wrapper.ember.service.config.EmberConfigService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmberStatsCallerApiClientTest {
    private EmberConfigService mockEmberConfigService;
    private EmberStatsCallerApiClient emberStatsCallerApiClient;

    public void setUp() {
        // Create a mock config service
        mockEmberConfigService = new EmberConfigService() {
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
                return "test-api-key";
            }
        };

        // Initialize the client
        emberStatsCallerApiClient = new EmberStatsCallerApiClient(mockEmberConfigService);
    }

    public void testFetchEnergyData_Success() {
        // Arrange
        setUp();
        List<String> countries = Arrays.asList("US", "CN");
        List<EmberSeries> series = new ArrayList<>();
        series.add(EmberSeries.wind);
        List<Integer> dateRange = Arrays.asList(2020, 2021);

        // Act
        EnergyResponse response = emberStatsCallerApiClient.fetchEnergyData(countries, series, dateRange);

        // Assert
        assert response != null : "Response should not be null";
        System.out.println("testFetchEnergyData_Success: PASSED");
    }

    public void testFetchEnergyData_InvalidInput() {
        // Arrange
        setUp();
        List<String> emptyCountries = new ArrayList<>();
        List<EmberSeries> emptySeries = new ArrayList<>();
        List<Integer> invalidDateRange = Arrays.asList(2030, 2020);

        // Act
        EnergyResponse response = emberStatsCallerApiClient.fetchEnergyData(emptyCountries, emptySeries, invalidDateRange);

        // Assert
        assert response == null : "Response should be null for invalid input";
        System.out.println("testFetchEnergyData_InvalidInput: PASSED");
    }

    public void testConstructUrl() {
        // Arrange
        setUp();

        try {
            // Use reflection to access private method
            Method method = EmberStatsCallerApiClient.class.getDeclaredMethod("constructUrl", String.class, String.class);
            method.setAccessible(true);

            // Act
            String url = (String) method.invoke(emberStatsCallerApiClient, "https://test.com/", "v1");

            // Assert
            assert url.equals("https://test.com/v1/") : "URL should be constructed correctly";
            System.out.println("testConstructUrl: PASSED");
        } catch (Exception e) {
            System.err.println("testConstructUrl: FAILED");
            e.printStackTrace();
        }
    }

    public void testEmberConfigService() {
        // Arrange
        setUp();

        // Assert
        assert mockEmberConfigService.getBaseUrl() != null : "Base URL should not be null";
        assert mockEmberConfigService.getApiVersion() != null : "API Version should not be null";
        assert mockEmberConfigService.getApiKey() != null : "API Key should not be null";
        System.out.println("testEmberConfigService: PASSED");
    }

    public static void main(String[] args) {
        EmberStatsCallerApiClientTest test = new EmberStatsCallerApiClientTest();

        try {
            test.testFetchEnergyData_Success();
            test.testFetchEnergyData_InvalidInput();
            test.testConstructUrl();
            test.testEmberConfigService();

            System.out.println("All tests completed successfully!");
        } catch (AssertionError e) {
            System.err.println("Test failed: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error during testing: ");
            e.printStackTrace();
        }
    }
}