package com.sap.cf.springboot.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sap.hcp.cf.logging.servlet.filter.RequestLoggingFilter;

/**
 * 
 * @author fabiano.rosa
 *
 */

@Configuration
public class ConfigLogging {

	@Bean
	public Filter requestLoggingFilter() {
		return new RequestLoggingFilter();
	}

}
