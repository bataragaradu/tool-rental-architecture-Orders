package com.rbinnovative.orders.configuration;

import com.rb.innovative.client.controller.DefaultApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderClientConfiguration {

    @Value("${service.orders.url}")
    private String ordersServiceUrl;

    @Bean
    public DefaultApi defaultApi() {
        DefaultApi defaultApi = new DefaultApi();
        defaultApi.getApiClient().setBasePath(ordersServiceUrl);
        return defaultApi;
    }
}
