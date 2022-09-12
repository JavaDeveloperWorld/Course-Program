package com.code.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Teacher {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private byte age;
    private byte status;
}
