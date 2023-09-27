package com.KAYAK.numberfrequencycalculatorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumberFrequencyCalculatorApiApplication {
	public static final String BASE_URL = "/api";

	public static void main(String[] args) {
		SpringApplication.run(NumberFrequencyCalculatorApiApplication.class, args);
	}

}
