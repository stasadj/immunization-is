package com.immunization.trustee.config;


import com.immunization.common.filter.FrontendRedirectFilter;
import com.immunization.common.security.RestAuthenticationEntryPoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // No session will be created or used by spring security
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and().authorizeRequests()
                // Keep authentication open but close all other requests.
                .antMatchers("/api/h2-console/**").permitAll()
                .anyRequest().permitAll()
                // .anyRequest().authenticated()
                .and().cors()
                .and().addFilterBefore(new FrontendRedirectFilter(), BasicAuthenticationFilter.class);

        http.csrf().disable(); // disable cross site request forgery, as we don't use cookies - otherwise ALL
                               // PUT, POST, DELETE will get HTTP 403
        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        // Ignore all requests to endpoints that do not contain /api/
        web.ignoring().regexMatchers(HttpMethod.GET, "/((?!api).*)");
    }
}
