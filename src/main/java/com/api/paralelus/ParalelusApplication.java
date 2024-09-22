package com.api.paralelus;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParalelusApplication {

	public static void main(String[] args) {
		var logger = LoggerFactory.getLogger(ParalelusApplication.class);

		SpringApplication.run(ParalelusApplication.class, args);
		logger.info(">>>>>>>>>>>>> Aplicação Iniciada");
	}

}
