package com.example.pracadomowa.controller.model.auth;

import com.example.pracadomowa.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AuthResponse {
    private Long id;
    private String login;
    private String token;

    public AuthResponse(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
    }
}
