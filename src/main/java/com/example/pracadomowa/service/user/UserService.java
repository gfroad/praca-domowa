package com.example.pracadomowa.service.user;

import com.example.pracadomowa.controller.model.auth.AuthRequest;
import com.example.pracadomowa.domain.User;

public interface UserService {
    User login(AuthRequest authRequest);
}
