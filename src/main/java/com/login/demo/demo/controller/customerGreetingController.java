package com.login.demo.demo.controller;

import com.login.demo.demo.model.Greeting;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1")
public class customerGreetingController {


    private static final String greetingTemplate = "Hello, %s %s";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam( value = "gender", defaultValue = "0") boolean gender,
                             @RequestParam( value = "customerName" , defaultValue = "Customer") String customerName) {
        return Greeting.builder()
                .id(counter.incrementAndGet())
                .content(String.format(greetingTemplate, gender ? "Mr." : "Ms.", customerName))
                .build();
    }
}
