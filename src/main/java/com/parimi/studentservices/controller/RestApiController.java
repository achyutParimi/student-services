package com.parimi.studentservices.controller;

import com.parimi.studentservices.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestApiController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @GetMapping("/greetings")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
