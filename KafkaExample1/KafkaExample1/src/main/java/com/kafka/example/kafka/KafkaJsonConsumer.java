package com.kafka.example.kafka;

import com.kafka.example.kafkaTwo.Car;
import com.kafka.example.kafkaTwo.CarRepository;
import com.kafka.example.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class KafkaJsonConsumer {

private static  final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);


      @Autowired
      private CarRepository carRepository;


    @KafkaListener(topics = "ajay_json",groupId = "myGroup")
    public void consume(User user){

        LOGGER.info(String.format("Json message received ->  "),user.toString());

        System.out.println("Json message received from ajay_json topic --> "+user.toString());

    }

    @KafkaListener(topics = "car_json",groupId = "myGroup")
    public void consumeCar(Car car){

        System.out.println("Json message received from ajay_json topic --> "+car.toString());

        carRepository.save(car);
    }


}
