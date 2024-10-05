package com.example.dummyjson.config;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties

/** Classe Yaml file que contem as configs do ambiente 
 * @author CarlosRenatoDomingos
 * @since 2024
 */
public class YAMLFileConfig {

	private String name;
    private String environmentName;
    private String url;
    private HashMap<String, String> server;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnvironmentName() {
		return environmentName;
	}
	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HashMap<String, String> getServer() {
		return server;
	}
	public void setServer(HashMap<String, String> server) {
		this.server = server;
	}
	
}
