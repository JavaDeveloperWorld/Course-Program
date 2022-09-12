package com.code.controller;

import com.code.model.Student;
import com.code.service.RabbitService;
import com.code.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    @Autowired
    StudentService studentService;
//    @Autowired
//    RabbitService rabbitService;

    @GetMapping
    public List<Student>getAllList(){
        return studentService.getAllList();
    }
//    @GetMapping("/bind/id")
//    public void getStudentById(@RequestParam int id){
//         rabbitService.sendStudentsToQueue(id);
//    }

    @GetMapping("/id")
    public Student getStudent(@RequestParam("id") int id){
        return studentService.getStudent(id);
    }
    @PostMapping
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
    @PutMapping
    public void updateStudent(@RequestBody Student student){
         studentService.updateStudent(student);
    }
    @DeleteMapping("/id")
    public void deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);
    }
}
