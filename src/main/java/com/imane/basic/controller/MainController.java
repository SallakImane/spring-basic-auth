package com.imane.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class MainController {

    @GetMapping(path = "/home")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/whoami")
    public ResponseEntity<?> index(Principal principal) {
        return ResponseEntity.ok().body(Map.of("username", principal.getName()));
    }
}
