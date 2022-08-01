package com.emsacode.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emsacode.model.Student;
public interface StudentRepository extends JpaRepository<Student, Long> {
  List<Student> findByNameContaining(String name);
  List<Student> findByMajor(String major);
}