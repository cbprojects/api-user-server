package com.project.cafe.api.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "config.swagger")
@Component
@Data
public class SwaggerProperties {
	private String title;
	private String description;
	private String terms;
	private ContactProperties contact;
	private String licence;
	private String licenceUrl;
	private String version;
}