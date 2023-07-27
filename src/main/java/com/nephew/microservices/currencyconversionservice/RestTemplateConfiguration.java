package com.nephew.microservices.currencyconversionservice;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/***
 * It is necessary to construct the RestTemplate through a bean in order
 * to see the entire tracing event in zipkin. 
 * @author Ethan
 * 
 * URL: http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10
 */
@Configuration(proxyBeanMethods = false)
public class RestTemplateConfiguration {
	
	@Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
	
}
