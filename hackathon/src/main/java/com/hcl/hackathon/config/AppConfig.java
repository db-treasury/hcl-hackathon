package com.hcl.hackathon.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.hcl.hackathon")
public class AppConfig {

	@SuppressWarnings("unchecked")
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())
				.paths((Predicate<String>) PathSelectors.any()).build();
	}
	
	@Bean 
	public DataSource getDataSource() { 
	    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create(); 
//	    dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
//	    dataSourceBuilder.url("jdbc:mysql://iassess.hclets.com:61116/hackathon");
	    dataSourceBuilder.username("demouser"); 
	    dataSourceBuilder.password("demouser@123"); 
	    return dataSourceBuilder.build(); 
	}
}
