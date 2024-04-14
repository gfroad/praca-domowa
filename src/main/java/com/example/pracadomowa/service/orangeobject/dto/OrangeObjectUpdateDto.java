package com.example.pracadomowa.service.orangeobject.dto;

import com.example.pracadomowa.enums.ObjectType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class OrangeObjectUpdateDto {
    private Long id;
    private String name;
    private String description;
    private ObjectType type;
    private Integer size;
}
