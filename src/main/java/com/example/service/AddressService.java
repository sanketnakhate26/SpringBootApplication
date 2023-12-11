package com.example.service;



import com.example.entity.Address;
import com.example.repository.AddressRepository;
import com.example.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    StudentService studentService;

    public List<AddressResponse> getAllAddress(){
        List<Address> addressList =  addressRepository.findAll();

        List<AddressResponse> addressResponseList = new ArrayList<>();
        addressList.stream().forEach(address -> {
            addressResponseList.add(new AddressResponse(address));
        });

        return addressResponseList;
    }


}
