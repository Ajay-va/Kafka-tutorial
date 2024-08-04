package com.kafka.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {


    @Bean
    public NewTopic newTopic(){

        return TopicBuilder.name("ajay")
                .build();


    }


    @Bean
    public NewTopic jsonData(){

        return TopicBuilder.name("ajay_json")
                .build();


    }


    @Bean
    public NewTopic carData(){

        return TopicBuilder.name("car_json")
                .build();


    }


}
