package com.example.controller;

import com.example.entity.Address;
import com.example.response.AddressResponse;
import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/address/")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("getAllAddress")
    public List<AddressResponse> getAllAddress(){
        return addressService.getAllAddress();
    }



}
