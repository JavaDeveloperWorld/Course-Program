package com.code.service;

import com.code.configuration.RabbitMQConfiguration;
import com.code.model.Student;
import com.code.repository.StudentRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitServiceImpl implements RabbitService{
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    StudentRepository studentRepository;


    @RabbitListener(queues = "student_request_queue")
    public void sendStudentsToQueue(int id) {
        System.out.println("Student id get and send student data back "+id);
        Student student=studentRepository.findById(id).orElse(null);
        rabbitTemplate.convertAndSend(RabbitMQConfiguration.topicName,"other",student);
    }
}
