package com.calendar.Lv4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv4CalendarApplication {

	public static void main(String[] args) { SpringApplication.run(Lv4CalendarApplication.class, args);	}
}
