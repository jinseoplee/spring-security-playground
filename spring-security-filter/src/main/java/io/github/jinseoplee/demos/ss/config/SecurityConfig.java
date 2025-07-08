package io.github.jinseoplee.demos.ss.config;

import io.github.jinseoplee.demos.ss.filter.ExecutionTimeFilter;
import io.github.jinseoplee.demos.ss.filter.RequestValidationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final RequestValidationFilter requestValidationFilter;
    private final ExecutionTimeFilter executionTimeFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(
                        requestValidationFilter,
                        BasicAuthenticationFilter.class
                )
                .addFilterAfter(
                        executionTimeFilter,
                        BasicAuthenticationFilter.class
                )
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}
