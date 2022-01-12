package com.immunization.backend.config;

import com.immunization.backend.util.AuthenticationUtilitiesExist;
import com.immunization.backend.util.AuthenticationUtilitiesFuseki;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@Configuration
public class DBConfig {
    @Bean
    public AuthenticationUtilitiesExist.ConnectionProperties existsDataSource() throws IOException {
        return AuthenticationUtilitiesExist.loadProperties();
    }

    @Bean
    public AuthenticationUtilitiesFuseki.ConnectionProperties fusekiDataSource() throws IOException {
        return AuthenticationUtilitiesFuseki.loadProperties();
    }
}
