package com.example.mvctest.controller;

import com.example.mvctest.dto.UserLoginRequestDTO;
import com.example.mvctest.dto.UserResponseDTO;
import com.example.mvctest.dto.UserSignupRequestDTO;
import com.example.mvctest.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody UserSignupRequestDTO requestDto) {
        userService.signUp(requestDto);
        return ResponseEntity.ok("User signed up successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@Valid @RequestBody UserLoginRequestDTO requestDto) {
        UserResponseDTO responseDto = userService.login(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Spring Security's logout handler will intercept this call
        return ResponseEntity.ok("Logged out successfully");
    }
}
