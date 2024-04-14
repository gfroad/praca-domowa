package com.example.pracadomowa.repository;

import com.example.pracadomowa.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.login = :login")
    Optional<User> findByLogin(@Param("login") String login);

}
