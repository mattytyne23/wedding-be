package com.example.rsvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RsvpApplication {
    public static void main(String[] args) {
        SpringApplication.run(RsvpApplication.class, args);
    }
}
