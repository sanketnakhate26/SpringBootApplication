package com.example.controller;

import com.example.entity.Student;
import com.example.request.CreateStudentRequest;
import com.example.request.UpdateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
            Student student =  studentService.createStudent(createStudentRequest);

            return new StudentResponse(student);
    }

    @PutMapping("update")
    public StudentResponse updateStudent(@RequestBody UpdateStudentRequest updateStudentRequest){
            Student student= studentService.updateStudent(updateStudentRequest);

            return new StudentResponse(student);
    }

    // delete method to handle id in the query params
//    @DeleteMapping("delete")
//    public String deleteStudent(@RequestParam Integer id){
//
//        return studentService.deleteStudent(id);
//    }
    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("getByFirstName/{firstName}")
    public List<StudentResponse> getByFirstName(@PathVariable String firstName){
        List<Student> students = studentService.getByFirstName(firstName);
        List<StudentResponse> studentResponses = new ArrayList<>();

        students.stream().forEach(student -> {
            studentResponses.add(new StudentResponse(student));
        });

        return studentResponses;
    }
}
