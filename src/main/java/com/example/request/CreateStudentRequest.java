package com.example.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentRequest {


    @NotBlank(message = "First Name is Required.")
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;
}
