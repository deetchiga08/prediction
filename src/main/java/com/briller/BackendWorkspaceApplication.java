package com.briller;

import com.briller.Model.general;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(general.class)
public class BackendWorkspaceApplication implements CommandLineRunner {

	private final general configuration;
	Logger logger = LoggerFactory.getLogger(BackendWorkspaceApplication.class);
	public BackendWorkspaceApplication(general configuration) {
		this.configuration = configuration;
	}
	@Override
	public void run(String... args) {



		logger.info("----------------------------------------");
		logger.info("Configuration properties");
		logger.info("   example.id is {}", configuration.getId());
		logger.info("   example.name is {}", configuration.getName());
		logger.info("----------------------------------------");
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendWorkspaceApplication.class, args);
	}
	@Bean
	public Docket productApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.briller")).build();
	}
}
