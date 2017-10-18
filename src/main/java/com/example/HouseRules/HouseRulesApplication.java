package com.example.HouseRules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = {HouseRulesApplication.class, Jsr310JpaConverters.class})

@SpringBootApplication
public class HouseRulesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseRulesApplication.class, args);
	}
}
