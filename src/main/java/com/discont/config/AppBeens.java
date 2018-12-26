package com.discont.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppBeens {

	@Bean
	RestTemplate restTemplateFactory() {
		return new RestTemplate();
	}

}