package com.imane.basic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/public")
public class PublicController {

    @GetMapping(path = "/home")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok().build();
    }
}