package com.example.repository;

import com.example.entity.Student;
import com.example.request.InQueryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByFirstName(String firstName);
    Student findByFirstNameAndAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameIn(List<String> firstNames);
}
