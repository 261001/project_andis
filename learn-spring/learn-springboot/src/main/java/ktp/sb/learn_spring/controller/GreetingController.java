package ktp.sb.learn_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // Tambahkan konteks umum jika diperlukan
public class GreetingController {
    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        return String.format("Hello,%s!", name);
    }
}
