package com.bookmycar.BookMyCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bookmycar.BookMyCar"})
public class BookMyCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyCarApplication.class, args);
	}

}
