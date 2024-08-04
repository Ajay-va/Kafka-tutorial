package com.kafka.example.controller;


import com.kafka.example.kafka.KafkaJsonProducer;
import com.kafka.example.kafkaTwo.Car;
import com.kafka.example.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jsonMessage")
public class JsonMessageController {


    @Autowired
    private KafkaJsonProducer kafkaJsonProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaJsonProducer.sednMessage(user);
        return ResponseEntity.ok("It is data sent successfully....!!!! ");
    }

    @PostMapping("/carPublish")
    public ResponseEntity<String> carPublish(@RequestBody Car car){
        kafkaJsonProducer.sendCarMessage(car);
        return ResponseEntity.ok("It is data sent successfully....!!!! ");
    }



}
