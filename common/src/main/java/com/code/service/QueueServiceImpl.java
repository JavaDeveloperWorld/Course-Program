package com.code.service;

import com.code.configuration.RabbitMQConfiguration;
import com.code.model.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class QueueServiceImpl {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void getStudentByQueue(int id){
        System.out.println("Student id sent!!");
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicName,"first_route",id);
    }

    @RabbitListener(queues = "student_response_queue",ackMode = "")
    public void getStudent(Student student){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("We got student data "+student);
    }
}
