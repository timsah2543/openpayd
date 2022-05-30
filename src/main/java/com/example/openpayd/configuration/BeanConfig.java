package com.example.openpayd.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class BeanConfig {
    @Bean
    public RestTemplate restTemplate()
    {
        RestTemplate rest = new RestTemplateBuilder().build();
        return rest;
    }

    @Bean
    public HttpHeaders httpHeaders()
    {
        return new HttpHeaders();
    }

    @Bean
    public ObjectMapper objectMapper()
    {
        return new ObjectMapper();
    }

    @Bean
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping()
    {
        return new RequestMappingHandlerMapping();
    }

}
