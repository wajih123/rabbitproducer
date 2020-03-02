package com.example.wajih.controllers;

import com.example.wajih.json.Student;
import com.example.wajih.producer.IProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private IProducer producer;

    @GetMapping("/send")
    public String sendMessage() {
        Student student = new Student("wajih", "tarsim", 26);
        producer.produceMesage(student);
        return student.toString();
    }
}
