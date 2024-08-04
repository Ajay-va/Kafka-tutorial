package com.kafka.example.controller;

import com.kafka.example.kafka.KafkaProducer;
import com.kafka.example.kafkaTwo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

//    public KafkaController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }

    @GetMapping("/sendMessage")
    public ResponseEntity<String>  publish(@RequestParam("message") String message){

        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Message sent successfully...!!!");
    }


    @PostMapping("/sendCarMessage")
    public ResponseEntity<String>  sendCarMessage(@RequestBody Car car){

        kafkaProducer.sendCarMessage(car);

        return ResponseEntity.ok("sent Car data successfully...!!!");
    }

}
