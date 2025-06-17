package com.springmicro.items.itemsmsvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Value("${config.base.endpoint.msvc-products}")
    private String url;

    @Bean
    @LoadBalanced// permite habilitar el balanceo de carga
    WebClient.Builder WebClient(){
        return WebClient.builder().baseUrl(url);
    }

}
