package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.service.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Data
@Component // Registers this class as a Spring bean
@ConfigurationProperties(prefix = "worldbank")
public class WorldBankConfig {
    @Value("${worldbank.base.url}")
    private String baseUrl;
    @Value("${worldbank.api.version}")
    private String apiVersion;
    @Value("${worldbank.prefix}")
    private String prefix;
    @Value("${worldbank.suffix}")
    private String suffix;
    @Value("${worldbank.format_keyword}")
    private String formatKeyword;
    @Value("${worldbank.formatvalue}")
    private String formatValue;
    @Value("${worldbank.per.page}")
    private String perPage;
}



