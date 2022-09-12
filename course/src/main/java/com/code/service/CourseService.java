package com.code.service;

import com.code.model.Course;

import java.util.List;

public interface CourseService {

    List<Course>getAllList();

    Course getCourse(int id);

    void insertCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(int id);
}
