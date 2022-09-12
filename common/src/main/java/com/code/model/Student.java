package com.code.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private byte age;
    private byte status;
}
