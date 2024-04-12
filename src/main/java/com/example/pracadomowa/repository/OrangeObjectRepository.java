package com.example.pracadomowa.repository;

import com.example.pracadomowa.domain.OrangeObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrangeObjectRepository extends CrudRepository<OrangeObject, Long> {

    @Query("select oo from OrangeObject oo")
    List<OrangeObject> findAll();
}
