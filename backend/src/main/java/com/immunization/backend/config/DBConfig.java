package com.immunization.backend.config;

import com.immunization.backend.util.AuthenticationUtilities;
import com.immunization.backend.util.AuthenticationUtilities.ConnectionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@Configuration
public class DBConfig {
    @Bean
    public ConnectionProperties existsDataSource() throws IOException {
        return AuthenticationUtilities.loadProperties();
    }
}
