package com.project.cafe.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "config.swagger")
@Component
@Data
public class ContactProperties {
	private String name;
	private String url;
	private String email;
}