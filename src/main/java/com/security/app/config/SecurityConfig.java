package com.security.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import lombok.RequiredArgsConstructor;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //csrf(AbstractHttpConfigurer::disable) Cross-Site Request Forgery CSRF
        return http
                .csrf( csrf ->
                        csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                           .requestMatchers("/auth/**").permitAll()
                           .anyRequest().fullyAuthenticated()
                        )
                .formLogin(Customizer.withDefaults())
                .build();
    }

}
