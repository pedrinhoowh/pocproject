package com.poc.vtexproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={
		"com.poc.vtexproject"})
public class PocVtexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocVtexApplication.class, args);
	}

}
