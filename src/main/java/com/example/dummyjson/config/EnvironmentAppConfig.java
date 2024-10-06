package com.example.dummyjson.config;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Classe de configuracao de ambiente da aplicacao
 * @author CarlosRenatoDomingos
 * @since 2024
 * 
 * */
@SpringBootApplication
public class EnvironmentAppConfig implements CommandLineRunner {

	Logger LOGGER = Logger.getLogger(EnvironmentAppConfig.class.getName());
	
    @Autowired
    private YamlFileConfig config;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EnvironmentAppConfig.class);
        app.run();
    }

    public void run(String ... args) throws Exception {
    	
    	LOGGER.info("************* ENVIRONMENT CONFIG **********");
    	
    	LOGGER.info(" Enviroment Configured: " + config.getEnvironmentName());
    	
    	LOGGER.info(" Server port: " + config.getServer().get("port"));
    	
    	LOGGER.info(" Name: " + config.getName());
    	
    	LOGGER.info(" URL: " + config.getUrl());
    	
    	LOGGER.info("********** ********** ********** **********");
    	
    }
}