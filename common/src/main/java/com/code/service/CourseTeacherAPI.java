package com.code.service;

import com.code.configuration.RabbitMQConfiguration;
import com.code.model.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class CourseTeacherAPI {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClient;



    private static final String courseMicroservices="http://course-service";
    private static final String teacherMicroservices="http://teacher-service";
    private static final String studentMicroservices="http://student-service";

    public CommonDetails getAllDetails(Common common){
        CommonDetails commonDetails=new CommonDetails();
        int courseId=common.getCourse_id();
        int teacherId=common.getTeacher_id();
        int studentId=common.getStudent_id();
        commonDetails.setCourse(restTemplate.getForObject(courseMicroservices+"/courses/id?id={courseId}", Course.class,courseId));
        commonDetails.setTeacher(restTemplate.getForObject(teacherMicroservices+"/teachers/id?id={teacherId}", Teacher.class,teacherId));
        commonDetails.setStudent(restTemplate.getForObject(studentMicroservices+"/students/id?id={studentId}", Student.class,studentId));
        return commonDetails;
    }

    public CommonDetails getDetailsByWebClient(Common common){
        CommonDetails commonDetails=new CommonDetails();
        int courseId=common.getCourse_id();
        int teacherId=common.getTeacher_id();
        int studentId=common.getStudent_id();
        commonDetails.setStudent(webClient.build()
                .get()
                .uri(studentMicroservices+"/students/id?id="+studentId)
                .retrieve()
                .bodyToMono(Student.class)
                .block());

        commonDetails.setCourse(webClient.build()
                .get()
                .uri(courseMicroservices+"/courses/id?id="+courseId)
                .retrieve()
                .bodyToMono(Course.class)
                .block());

        commonDetails.setTeacher(webClient.build()
                .get()
                .uri(teacherMicroservices+"/teachers/id?id="+teacherId)
                .retrieve()
                .bodyToMono(Teacher.class)
                .block());

        return commonDetails;
    }



}
