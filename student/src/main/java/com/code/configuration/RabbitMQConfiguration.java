package com.code.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    private static final String queueName="student_response_queue";

    public static final String topicName="student_topic";



    @Bean
    public Queue queue(){
        return new Queue(queueName,false);
    }



    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(topicName);
    }

    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("other");
    }


}
