package com.example.controller;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/get")
    public String getStudent(){
        return "Hello Student";
    }
}
