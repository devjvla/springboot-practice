package dev.jvla.springboot_tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class HelloController {
    @GetMapping("/")
    public String greet(@RequestParam(value = "name", defaultValue = "SpringBoot") String name) {
        return "Hello, " + name + "!";
    }
}
