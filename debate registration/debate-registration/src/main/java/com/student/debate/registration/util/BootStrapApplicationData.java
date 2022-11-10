package com.student.debate.registration.util;


import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.student.debate.registration.entity.Student;
import com.student.debate.registration.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Configuration

public class BootStrapApplicationData {

	@Autowired
	private StudentRepository stdRepo;


	@EventListener(ApplicationReadyEvent.class)
	public void insertEmployee(ApplicationReadyEvent event) {
		
		Student std1 = new Student();
		std1.setFName("Suresh");
		std1.setLName("Reddy");
		std1.setCourse("B.Tech");
		std1.setCountry("India");
		
		Student std2 = new Student();
		std2.setFName("Suresh");
		std2.setLName("Reddy");
		std2.setCourse("B.Tech");
		std2.setCountry("India");
		
		stdRepo.save(std1);
		stdRepo.save(std2);
		
	}

}
