package com.kafka.example.kafka;

import com.kafka.example.kafkaTwo.Car;
import com.kafka.example.payload.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    private static  final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sednMessage(User user){

        LOGGER.info("Message sent --> ",user.toString());
        System.out.println("=================================");
        LOGGER.info(String.format("Message sent --> "),user.toString());
        Message<User> message= MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC ,"ajay_json")
                .build();

        kafkaTemplate.send(message);

    }

    public void sendCarMessage(Car car){



        LOGGER.info("Message sent --> ",car.toString());
        System.out.println("=================================");

        Message<Car> message= MessageBuilder.withPayload(car)
                .setHeader(KafkaHeaders.TOPIC ,"car_json")
                .build();

        kafkaTemplate.send(message);

    }



}