package com.code.model;

import lombok.Data;

@Data
public class Course {
    private int id;
    private String course_name;
    private String course_price;
    private String week_hour;
    private byte status;
}
