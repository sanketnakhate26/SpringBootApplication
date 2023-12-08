package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentResponse> getAllStudents(){
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        List<Student> studentsList = studentRepository.findAll();

        studentsList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });
        return studentResponseList;
    }
}
