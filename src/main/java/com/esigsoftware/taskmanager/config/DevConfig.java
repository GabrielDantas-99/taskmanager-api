package com.esigsoftware.taskmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.esigsoftware.taskmanager.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciandoBD() {
		if (strategy.equals("create")) {
			this.dbService.instanciandoBD();
		} 
		return false;
	}
	
}
