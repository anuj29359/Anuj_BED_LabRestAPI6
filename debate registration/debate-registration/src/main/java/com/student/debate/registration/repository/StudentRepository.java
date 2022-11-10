package com.student.debate.registration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.debate.registration.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
