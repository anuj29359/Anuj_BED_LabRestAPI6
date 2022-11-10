package com.student.debate.registration.service;

import java.util.List;

import com.student.debate.registration.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	public Student createNewStudent(Student std);
	//public Student updateStudent(Student std);
	public void deleteStudent(Long stdId);
	public Student updateStudent(Long stdId, Student std);
	
	

}
