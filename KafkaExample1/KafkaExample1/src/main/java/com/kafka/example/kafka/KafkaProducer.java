package com.kafka.example.kafka;

import com.kafka.example.kafkaTwo.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {


    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);


    private KafkaTemplate<String,String>  kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String message){

        LOGGER.info(String.format("Message sent --> %s",message));
        kafkaTemplate.send("ajay",message);

    }

    public void sendCarMessage(Car car){

        LOGGER.info(String.format("Message sent --> %s",car.toString()));
        kafkaTemplate.send("car_json", car.toString());

    }

}
