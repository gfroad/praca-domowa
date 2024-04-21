package com.example.pracadomowa.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.pracadomowa.domain.User;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserAuthenticationProvider {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(User user) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withSubject(user.getLogin())
                .withIssuedAt(now)
                .withClaim("roles", user.getRoleNames())
                .withExpiresAt(validity)
                .sign(algorithm);
    }

    public Authentication validateToken(String token, HttpServletRequest request) {
        var userDetails = getUserDetails(token);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    private UserDetails getUserDetails(String token) {
        var verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();

        var decoded = verifier.verify(token);
        var roles = decoded.getClaim("roles").toString();

        roles = roles
                .replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .replace(" ", "");

        var roleNames = roles.split(",");


        return org.springframework.security.core.userdetails.User.builder()
                .username(decoded.getSubject())
                .password("")
                .roles(roleNames)
                .authorities(Arrays.stream(roleNames)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()))
                .disabled(false)
                .build();
    }

}
