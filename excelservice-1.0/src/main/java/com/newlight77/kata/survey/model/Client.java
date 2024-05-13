package com.newlight77.kata.survey.model;

import lombok.Data;

@Data
public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
}
