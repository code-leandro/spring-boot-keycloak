package com.leandrodev.springbootkeycloak.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping(value = "/unknown")
    public ResponseEntity<String> getUnknownUser() {
        return ResponseEntity.ok("Hello Unknown User");
    }

    @RolesAllowed("user")
    @GetMapping(value = "/normal-user")
    public ResponseEntity<String> getNormalUser() {
        return ResponseEntity.ok("Hello Normal User");
    }

    @RolesAllowed("admin")
    @GetMapping(value = "/admin-user")
    public ResponseEntity<String> getAdminUser() {
        return ResponseEntity.ok("Hello Admin User");
    }
    
    @GetMapping(value = "/create")
    public ResponseEntity<String> create() {
        return ResponseEntity.ok(new Teste().test());
    }
}
