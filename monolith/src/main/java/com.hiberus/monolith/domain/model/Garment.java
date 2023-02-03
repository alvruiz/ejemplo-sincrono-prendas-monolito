package com.hiberus.monolith.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Garment {

    public static final String NOT_VALID_ARGUMENTS = "Not valid arguments";

    private String id;
    private String name;
    private int quantity;
    private Size size;

    public Garment(String id,String name, int quantity, Size size){
        if(id == null||name == null || quantity < 0 || size == null)
            throw new IllegalArgumentException(NOT_VALID_ARGUMENTS);
        this.id =id;
        this.name = name;
        this.quantity = quantity;
        this.size = size;
    }
    public Garment(String name, int quantity, Size size){
        if(name == null || quantity < 0 || size == null)
            throw new IllegalArgumentException(NOT_VALID_ARGUMENTS);
        this.id = name+size;
        this.name = name;
        this.quantity = quantity;
        this.size = size;
    }



}
