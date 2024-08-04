package com.real.world.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerImplementation {

    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProducerImplementation.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;




}
