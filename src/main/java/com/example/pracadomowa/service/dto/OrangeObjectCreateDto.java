package com.example.pracadomowa.service.dto;

import com.example.pracadomowa.enums.ObjectType;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class OrangeObjectCreateDto {
    private String name;
    private String description;
    private ObjectType type;
    private Integer size;
}
