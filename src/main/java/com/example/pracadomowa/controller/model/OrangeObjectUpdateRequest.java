package com.example.pracadomowa.controller.model;

import com.example.pracadomowa.enums.ObjectType;
import lombok.Data;

@Data
public class OrangeObjectUpdateRequest {
    private String name;
    private String description;
    private ObjectType type;
    private Integer size;
}
