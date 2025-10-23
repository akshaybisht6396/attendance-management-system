package com.yourcompany.student.attendance.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AttendanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttendanceServiceApplication.class, args);
    }

    /**
     * Creates a RestTemplate bean to be used for making HTTP requests to other services.
     * @return A RestTemplate instance.
     */
    @Bean
    @LoadBalanced // This annotation enables client-side load balancing with Eureka
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}