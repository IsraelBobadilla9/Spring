package com.security.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class ProjectSecurityConfig {
    @Bean
		SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
            System.out.println("============== PERSONAL BEAN ===============");
			// http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
            http.authorizeHttpRequests((request) -> request.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
            .requestMatchers("/notices","/contact","/error").permitAll());
            http.formLogin(httpSecurityFormLoginConfiguration -> {
                httpSecurityFormLoginConfiguration.disable();
            });
			http.httpBasic(httpBasicConfig -> httpBasicConfig.disable());
            http.httpBasic(withDefaults());
			return http.build();
		}
}
