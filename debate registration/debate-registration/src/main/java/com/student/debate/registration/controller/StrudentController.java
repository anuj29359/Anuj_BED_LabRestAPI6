package com.student.debate.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.debate.registration.entity.Student;
import com.student.debate.registration.repository.StudentRepository;
import com.student.debate.registration.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StrudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private StudentServiceImpl stdSvc;
	

	@GetMapping("/all")
	public List<Student> getAllStudents(){
		return stdSvc.getAllStudents();
	}
	
	@PostMapping()
	public Student addStudent(@RequestBody Student std) {
		
		return stdSvc.createNewStudent(std);	
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable("id")  Long stdId, @RequestBody Student newStd) {
		System.out.println("Updating the student");
		Student oldStd = studentRepo.getById(stdId);
		System.out.println("Updating the student " + oldStd);
		return stdSvc.updateStudent(stdId, newStd);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable("id") Long stdId) {
		
		stdSvc.deleteStudent(stdId);
	}

}
