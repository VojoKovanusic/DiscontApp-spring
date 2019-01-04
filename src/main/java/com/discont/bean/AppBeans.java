package com.discont.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppBeans {

	@Bean
	RestTemplate restTemplateFactory() {
		return new RestTemplate();
	}

}