package com.code.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "common")
public class Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "student_id")
    private int student_id;
    @Column(name = "course_id")
    private int course_id;
    @Column(name = "teacher_id")
    private int teacher_id;
}
