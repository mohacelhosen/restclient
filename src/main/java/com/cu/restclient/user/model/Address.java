package com.cu.restclient.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String apartment;
    private String city;
    private String zipcode;
    private Geo geo;
}
