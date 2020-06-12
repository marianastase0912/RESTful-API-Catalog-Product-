package com.maria.springjwtcatalog;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="application", ignoreUnknownFields=false)
public class ApplicationProperties {
	private String secretKey;

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
}
