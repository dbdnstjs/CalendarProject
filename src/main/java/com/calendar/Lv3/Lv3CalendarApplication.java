package com.calendar.Lv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Lv3CalendarApplication {

	public static void main(String[] args) { SpringApplication.run(Lv3CalendarApplication.class, args);	}
}
