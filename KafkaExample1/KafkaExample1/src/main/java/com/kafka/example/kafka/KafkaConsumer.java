package com.kafka.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private final static Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "ajay",groupId = "myGroup")
    public void consumes(String message){

        LOGGER.info(String.format("Message received -> ",message));

        System.out.println(message);


    }



}
