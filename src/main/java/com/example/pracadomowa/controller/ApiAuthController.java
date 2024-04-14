package com.example.pracadomowa.controller;

import com.example.pracadomowa.config.UserAuthenticationProvider;
import com.example.pracadomowa.controller.model.auth.AuthRequest;
import com.example.pracadomowa.controller.model.auth.AuthResponse;
import com.example.pracadomowa.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/auth")
public class ApiAuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest credentialsDto) {
        var user = userService.login(credentialsDto);
        var authResponse = new AuthResponse(user);
        authResponse.setToken(userAuthenticationProvider.createToken(user));
        return ResponseEntity.ok(authResponse);
    }

}
