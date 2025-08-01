package com.calendar.Lv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv2CalendarApplication {

	public static void main(String[] args) { SpringApplication.run(Lv2CalendarApplication.class, args);	}
}
