package com.example.demo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("2.4.5") String appVersion) {

		return new OpenAPI()
				.info(new Info()
						.title("Banking Transaction")
						.version(appVersion)
						.description("Banking Application")
				)
				.addServersItem(new Server().url("http://localhost:8080/"));
	}
}


