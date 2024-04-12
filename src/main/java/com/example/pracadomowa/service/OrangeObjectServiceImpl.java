package com.example.pracadomowa.service;

import com.example.pracadomowa.domain.OrangeObject;
import com.example.pracadomowa.service.dto.OrangeObjectCreateDto;
import com.example.pracadomowa.service.dto.OrangeObjectUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.pracadomowa.repository.OrangeObjectRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrangeObjectServiceImpl implements OrangeObjectService {

    private final OrangeObjectRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<OrangeObject> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrangeObject> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public OrangeObject create(OrangeObjectCreateDto dto) {
        var orangeObject = new OrangeObject();

        orangeObject.setName(dto.getName());
        orangeObject.setDescription(dto.getDescription());
        orangeObject.setSize(dto.getSize());
        orangeObject.setType(dto.getType());

        return repository.save(orangeObject);
    }

    @Override
    @Transactional
    public OrangeObject update(OrangeObjectUpdateDto dto) {
        var orangeObjectOpt = getById(dto.getId());

        if (orangeObjectOpt.isEmpty()) {
            return null;
        }
        var orangeObject = orangeObjectOpt.get();
        orangeObject.setName(dto.getName());
        orangeObject.setDescription(dto.getDescription());
        orangeObject.setSize(dto.getSize());
        orangeObject.setType(dto.getType());

        return repository.save(orangeObject);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
