package com.code.service;

import com.code.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllList();

    Student getStudent(int id);

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);





}
