package com.example.service;

import com.example.entity.Address;
import com.example.entity.Student;
import com.example.repository.AddressRepository;
import com.example.repository.StudentRepository;
import com.example.request.CreateStudentRequest;
import com.example.request.InQueryRequest;
import com.example.request.UpdateStudentRequest;
import com.example.response.StudentResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    public Student createStudent (CreateStudentRequest createStudentRequest){
        Student student = new Student(createStudentRequest);

        Address address = new Address();
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());

        address = addressRepository.save(address);

        student.setAddress(address);

        student = studentRepository.save(student);
        return student;
    }

    public Student updateStudent(UpdateStudentRequest updateStudentRequest){
        Student student = studentRepository.findById(updateStudentRequest.getId()).get();
        if(updateStudentRequest.getFirstName() != null && !updateStudentRequest.getFirstName().isEmpty()){
            student.setFirstName(updateStudentRequest.getFirstName());
        }
        if(updateStudentRequest.getLastName() != null && !updateStudentRequest.getLastName().isEmpty()){
            student.setLastName(updateStudentRequest.getLastName());
        }
        if(updateStudentRequest.getEmail() != null && !updateStudentRequest.getEmail().isEmpty()){
            student.setEmail(updateStudentRequest.getEmail());
        }

        student = studentRepository.save(student);
        return student;
    }

    public String deleteStudent(Integer id){
        try {
            Student student = studentRepository.findById(id).get();
            if(null == student)
                return "Student does not exist.";
        }catch (Exception e){
            return "Exception : "+e;
        }

        studentRepository.deleteById(id);
        return "Student has been delete Successfully.";
    }

    public List<Student> getByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName);
    }

    public Student getByFirstNameAndLastName(String firstName, String lastName){
        return studentRepository.findByFirstNameAndAndLastName(firstName,lastName);
    }

    public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest){
        return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
    }

    public List<Student> getAllStudentsWithPagination(Integer pageSize, Integer pageNumber)
    {
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);

        List<Student> studentList =  studentRepository.findAll(pageable).getContent();

        return studentList;
    }

    public List<Student> getAllWithSort(){
        Sort sort = Sort.by(Sort.Direction.ASC,"firstName");

        List<Student> studentList = studentRepository.findAll(sort);

        return studentList;
    }

    public List<Student> getAllStudentsLike(String firstName)
    {
        return studentRepository.findByFirstNameContains(firstName);
    }

    public List<Student> getAllStudentsStartsWith(String firstName)
    {
        return studentRepository.findByFirstNameStartsWith(firstName);
    }

    public Student getAllStudentsWithFirstNameAndLastNameQuery(String firstName, String lastName)
    {
        return studentRepository.getAllStudentsWithFirstNameAndLastNameQuery(firstName,lastName);
    }

    public Integer updateFirstNameWithIdJPQL(Integer id, String firstName)
    {
        return studentRepository.updateFirstNameWithIdJPQL(id,firstName);
    }

    public Integer deleteStudentByFirstNameJSQL(String firstName)
    {
        return studentRepository.deleteStudentByFirstNameJSQL(firstName);
    }

    public List<Student> getStudentByCity(String city)
    {
        return studentRepository.findByAddress_City(city);
    }
}
