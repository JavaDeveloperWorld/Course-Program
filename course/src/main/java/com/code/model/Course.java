package com.code.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "course_name")
    private String course_name;
    @Column(name = "course_price")
    private String course_price;
    @Column(name = "week_hour")
    private String week_hour;
    @Column(name = "status")
    private byte status;
}
