package io.github.jinseoplee.demos.ss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();

        var guest = User.withUsername("guest")
                .password("1234")
                .roles("GUEST")
                .build();

        var user = User.withUsername("user")
                .password("1234")
                .roles("USER")
                .build();

        var manager = User.withUsername("manager")
                .password("1234")
                .roles("MANAGER")
                .build();

        var admin = User.withUsername("admin")
                .password("1234")
                .roles("ADMIN")
                .build();

        userDetailsManager.createUser(guest);
        userDetailsManager.createUser(user);
        userDetailsManager.createUser(manager);
        userDetailsManager.createUser(admin);

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
