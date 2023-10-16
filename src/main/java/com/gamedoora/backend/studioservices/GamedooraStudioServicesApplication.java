package com.gamedoora.backend.studioservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.gamedoora.model.*" , "com.gamedoora.backend.*"} , exclude = {DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class})
@EntityScan(basePackages = "com.gamedoora.model.dao") //added since Not a managed type: class com.gamedoora.model.dao.Studios
public class GamedooraStudioServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamedooraStudioServicesApplication.class, args);
	}

}
