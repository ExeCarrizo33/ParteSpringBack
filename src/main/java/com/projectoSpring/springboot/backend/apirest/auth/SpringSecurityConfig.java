package com.projectoSpring.springboot.backend.apirest.auth;


import com.projectoSpring.springboot.backend.apirest.auth.filter.JwtAuthenticationFilter;
import com.projectoSpring.springboot.backend.apirest.auth.filter.JwtValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(authHttp ->
                authHttp
                        .requestMatchers(HttpMethod.GET, "api/clientes", "api/clientes/page/{page}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/clientes/{}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/clientes/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/clientes/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated())
                        .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                        .addFilter(new JwtValidationFilter(authenticationManager()))
                        .csrf(config -> config.disable())
                        .sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        .build();

    }


}
