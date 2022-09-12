package com.code.controller;

import com.code.model.Course;
import com.code.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseRestController {
    @Autowired
    CourseService courseService;

    @GetMapping
    public List<Course>getAllCourse(){
        return courseService.getAllList();
    }
    @GetMapping("/id")
    public Course getCourse(@RequestParam("id") int id){
        return courseService.getCourse(id);
    }
    @PostMapping
    public void insertCourse(@RequestBody Course course){
        courseService.insertCourse(course);
    }
    @PutMapping
    public void updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
    }
    @DeleteMapping("/courseId")
    public void deleteCourse(@RequestParam("id") int id) {
        courseService.deleteCourse(id);
    }
}
