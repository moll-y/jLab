package com.example.restservicecors;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private final String TEMPLATE = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
  }

  @GetMapping("/greeting-javaconfig")
  public Greeting greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
    System.out.println("==== in greeting ====");
    return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
  }
}
