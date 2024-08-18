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
                        .anyRequest()
                        .authenticated()
                );
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
