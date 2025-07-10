package io.github.jinseoplee.demos.ss.config;

import io.github.jinseoplee.demos.ss.filter.CsrfTokenLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final CsrfTokenLogger csrfTokenLogger;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(
                        csrfTokenLogger,
                        CsrfFilter.class
                )
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .defaultSuccessUrl("/", true)
                );

        return http.build();
    }
}
