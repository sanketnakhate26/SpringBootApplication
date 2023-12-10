package com.example.response;

import com.example.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {
//    @JsonIgnore
    @JsonProperty("ID ")
    private int id;
    @JsonProperty("First Name")
    private String first_name;
    @JsonProperty("Last Name")
    private String last_name;
    @JsonProperty("Email ID")
    private String email;
    @JsonProperty("Street")
    private String street;
    @JsonProperty("City")
    private String city;

    public StudentResponse(Student student){
        this.id=student.getId();
        this.first_name = student.getFirstName();
        this.last_name = student.getLastName();
        this.email = student.getEmail();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();
    }

}
