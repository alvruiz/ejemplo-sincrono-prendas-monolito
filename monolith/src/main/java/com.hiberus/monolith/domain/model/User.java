package com.hiberus.monolith.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    public static final String NOT_VALID_ARGUMENTS = "Not valid arguments";
    public static final String REGGEX = "^[0-9]{8}[A-Z]";
    private String id;
    private String name;


    public User(String id, String name){
        if(!id.matches(REGGEX) || id == null||name == null)
            throw new IllegalArgumentException(NOT_VALID_ARGUMENTS);
        this.id =id;
        this.name = name;

    }




}
