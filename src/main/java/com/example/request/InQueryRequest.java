package com.example.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class InQueryRequest {
    private List<String> firstNames;
}
