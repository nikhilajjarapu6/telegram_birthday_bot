package com.telegramAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TelegramApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramApiApplication.class, args);
	}
	
	

}
