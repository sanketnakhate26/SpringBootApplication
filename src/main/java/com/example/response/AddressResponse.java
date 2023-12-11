package com.example.response;

import com.example.entity.Address;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {

    private Integer id;
    private String street;
    private String city;
    private String firstName;
    private String lastName;
    private String email;

    public AddressResponse(Address address)
    {
        this.id=address.getId();
        this.city=address.getCity();
        this.street=address.getStreet();
        this.firstName=address.getStudent().getFirstName();
        this.lastName=address.getStudent().getLastName();
        this.email=address.getStudent().getEmail();
    }

}
