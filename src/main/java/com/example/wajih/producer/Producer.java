package com.example.wajih.producer;

import com.example.wajih.json.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer implements IProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${udemy.rabbitmq.exchange}")
    private String exchange;

    @Value("${udemy.rabbitmq.rootingkey}")
    private String rootingkey;

    @Override
    public void produceMesage(Student message) {
        amqpTemplate.convertAndSend(exchange, rootingkey, message);
        System.out.println("sending message = "+ message);

    }
}
