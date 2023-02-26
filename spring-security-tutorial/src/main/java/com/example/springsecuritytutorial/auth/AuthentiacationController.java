package com.example.springsecuritytutorial.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthentiacationController {

    private final AuthentiacationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthentiacationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthentiacationResponse> authenticate(
            @RequestBody AuthentitcationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
