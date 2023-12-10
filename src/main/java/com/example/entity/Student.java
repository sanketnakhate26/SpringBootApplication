package com.example.entity;

import com.example.request.CreateStudentRequest;
import com.example.response.StudentResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    public Student(CreateStudentRequest createStudentRequest){
        this.firstName=createStudentRequest.getFirstName();
        this.lastName= createStudentRequest.getLastName();
        this.email= createStudentRequest.getEmail();
    }

}
