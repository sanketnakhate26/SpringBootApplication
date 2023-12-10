package com.example.repository;

import com.example.entity.Student;
import com.example.request.InQueryRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByFirstName(String firstName);
    Student findByFirstNameAndAndLastName(String firstName, String lastName);
    List<Student> findByFirstNameIn(List<String> firstNames);
    List<Student> findByFirstNameContains(String firstName);
    List<Student> findByFirstNameStartsWith(String firstName);

    @Query("from Student WHERE firstName =:firstName AND lastName=:lastName")
    Student getAllStudentsWithFirstNameAndLastNameQuery(String firstName, String lastName);
//@Modifying annotations will have either Integer (no of records updated) or void return type
    @Modifying
    @Transactional
    @Query("update Student set firstName=:firstName where id=:id")
    Integer updateFirstNameWithIdJPQL(Integer id, String firstName);

    @Modifying
    @Transactional
    @Query("delete from Student where firstName=:firstName")
    Integer deleteStudentByFirstNameJSQL(String firstName);

    List<Student> findByAddress_City(String city);

}
