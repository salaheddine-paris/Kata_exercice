package com.newlight77.kata.survey.model;

import lombok.Data;

import java.util.List;

@Data
public class Survey {
    private String id;
    private String sommary;
    private Client client;
    private List<Question> questions;
}

