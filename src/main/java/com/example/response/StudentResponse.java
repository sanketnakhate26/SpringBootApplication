package com.example.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {
//    @JsonIgnore
    private int id;
    @JsonProperty("First Name")
    private String first_name;
    @JsonProperty("Last Name")
    private String last_name;
    @JsonProperty("Email ID")
    private String email;

}
