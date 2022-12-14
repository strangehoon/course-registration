package com.strangehoon.courseregistration.repository;

import com.strangehoon.courseregistration.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByLoginId(String loginId);
}
