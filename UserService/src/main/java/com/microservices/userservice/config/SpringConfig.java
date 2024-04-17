package com.microservices.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

	@Bean
	@LoadBalanced // used to indicate that a RestTemplate bean should be configured for
					// client-side load balancing.
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}
}
