package com.example.pracadomowa.controller.model;

import com.example.pracadomowa.domain.OrangeObject;
import com.example.pracadomowa.enums.ObjectType;
import lombok.Data;

@Data
public class OrangeObjectResponse {
    private Long id;
    private String name;
    private String description;
    private ObjectType type;
    private Integer size;

    public OrangeObjectResponse(OrangeObject orangeObject) {
        this.id = orangeObject.getId();
        this.name = orangeObject.getName();
        this.description = orangeObject.getDescription();
        this.type = orangeObject.getType();
        this.size = orangeObject.getSize();
    }
}
