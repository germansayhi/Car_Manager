package com.vti.kshop.kshopdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {
        http
                .csrf(customizer -> customizer.disable())
                .cors(customizer ->{})
                .httpBasic(customizer ->{})
                .sessionManagement(customizer ->customizer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Không lưu trạng thái đăng nhập
                .authorizeHttpRequests(customizer ->customizer
                        .requestMatchers(HttpMethod.POST,"/api/v1/users")
                        .permitAll()
//                        .requestMatchers(HttpMethod.GET,"/api/v1/login")
//                        .permitAll()
                        .anyRequest()
                        .authenticated()
                );
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        var configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // http://127.0.0.1:5500
        configuration.setAllowedMethods(Arrays.asList("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE"));
        configuration.applyPermitDefaultValues();

        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
