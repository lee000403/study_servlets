package com.example.study_servlets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // servlet을 인식하여 scan하게금 캡을 씌움(class중에서 survlet으로 구현할거를 list up함)
@SpringBootApplication
public class StudyServletsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyServletsApplication.class, args);
	}

}
