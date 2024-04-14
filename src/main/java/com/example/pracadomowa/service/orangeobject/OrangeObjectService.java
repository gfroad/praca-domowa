package com.example.pracadomowa.service.orangeobject;

import com.example.pracadomowa.domain.OrangeObject;
import com.example.pracadomowa.service.orangeobject.dto.OrangeObjectCreateDto;
import com.example.pracadomowa.service.orangeobject.dto.OrangeObjectUpdateDto;

import java.util.List;
import java.util.Optional;

public interface OrangeObjectService {
    List<OrangeObject> getAll();

    Optional<OrangeObject> getById(Long id);

    OrangeObject create(OrangeObjectCreateDto dto);

    OrangeObject update(OrangeObjectUpdateDto dto);

    void delete(Long id);
}
