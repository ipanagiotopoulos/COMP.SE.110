package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.wrapper.ember.service.config;


import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
@Getter
public class EmberConfigService {
    @Value("${ember.base.url}")
    private String baseUrl;
    @Value("${ember.api.version}")
    private String apiVersion;
    @Value("${ember.api.version.suffix}")
    private String suffix;
    @Value("${ember.api.key}")
    private String apiKey;
}

