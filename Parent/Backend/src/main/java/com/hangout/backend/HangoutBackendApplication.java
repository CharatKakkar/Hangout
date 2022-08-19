package com.hangout.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.hangout.common.entity")
public class HangoutBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(HangoutBackendApplication.class, args);
    }

}
