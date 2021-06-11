package com.example.demointerceptor.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HomeController {
    
    @GetMapping("/home")
    public ResponseEntity<?> home() {
        log.info("====== call home ====");
        return ResponseEntity.ok().body("welcome home");
    }

    @GetMapping("/home/deny")
    public ResponseEntity<?> deny() {
        log.info("====== call deny ====");
        return ResponseEntity.ok().body("deny url");
    }
}
