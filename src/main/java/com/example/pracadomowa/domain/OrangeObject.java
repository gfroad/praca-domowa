package com.example.pracadomowa.domain;

import com.example.pracadomowa.enums.ObjectType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OrangeObject {

    @Id
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private ObjectType type;

    private Integer size;
}
