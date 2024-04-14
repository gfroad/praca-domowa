package com.example.pracadomowa.service.user;

import com.example.pracadomowa.controller.model.auth.AuthRequest;
import com.example.pracadomowa.domain.User;
import com.example.pracadomowa.exception.AppException;
import com.example.pracadomowa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public User login(AuthRequest authRequest) {
        User user = userRepository.findByLogin(authRequest.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (authRequest.password().equals(user.getPassword())) {
            return user;
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

}
