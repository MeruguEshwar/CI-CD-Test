package com.ojas.otrial;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OTrialApplication {

	public static void main(String[] args) {
		SpringApplication.run(OTrialApplication.class, args);

//		LocalDate start = YearMonth.now().atDay(1);
//		LocalDate end = YearMonth.now().atEndOfMonth();
//
//		for (int i = start.getDayOfMonth(); i <= end.getDayOfMonth(); i++) {
//			System.out.println(YearMonth.now().atDay(i)+"|"+start.getDayOfWeek()+"|"+"bla bla bla");
//		}
	}
}
