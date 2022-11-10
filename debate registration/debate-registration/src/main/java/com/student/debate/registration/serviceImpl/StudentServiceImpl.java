package com.student.debate.registration.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.debate.registration.entity.Student;
import com.student.debate.registration.repository.StudentRepository;
import com.student.debate.registration.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository stdRepo;

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return stdRepo.findAll();
	}

	@Override
	public Student createNewStudent(Student std) {
		// TODO Auto-generated method stub
		
		stdRepo.save(std);
		System.out.println("Created new student "+ stdRepo.getById(std.getId()));
		return stdRepo.getById(std.getId());
		
	}

	@Override
	public Student updateStudent(Long stdId, Student std) {
		// TODO Auto-generated method stub
		
		Student oldStd = stdRepo.getById(stdId);
		if (oldStd == null) {
			System.out.println("Cant update the mentioned studentId. no rec found");
		}
		else {
			oldStd.setCountry(std.getCountry());
			oldStd.setCourse(std.getCourse());
			oldStd.setFName(std.getFName());
			oldStd.setLName(std.getLName());

			stdRepo.save(oldStd);
		}
		
		System.out.println("Updated student " + oldStd);
		return oldStd;
	}

	@Override
	public void deleteStudent(Long stdId) {
		// TODO Auto-generated method stub
		
		System.out.println("Student deleting... " + stdRepo.getById(stdId).toString());
		stdRepo.deleteById(stdId);
		
	}

}
