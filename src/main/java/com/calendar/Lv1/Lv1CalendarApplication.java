package com.calendar.Lv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv1CalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lv1CalendarApplication.class, args);
	}
}
