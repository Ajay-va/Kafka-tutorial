package com.kafka.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaExample1Application {

	public static void main(String[] args) {
		SpringApplication.run(KafkaExample1Application.class, args);
		System.out.println("Welcome to Kafka Example1...!!!!");
	}

}
