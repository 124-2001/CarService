package com.example.carservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
