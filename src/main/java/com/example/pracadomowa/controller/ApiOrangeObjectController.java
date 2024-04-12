package com.example.pracadomowa.controller;

import com.example.pracadomowa.controller.model.OrangeObjectCreateRequest;
import com.example.pracadomowa.controller.model.OrangeObjectUpdateRequest;
import com.example.pracadomowa.service.OrangeObjectService;
import com.example.pracadomowa.controller.model.OrangeObjectResponse;
import com.example.pracadomowa.service.dto.OrangeObjectCreateDto;
import com.example.pracadomowa.service.dto.OrangeObjectUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/test")
@AllArgsConstructor
public class ApiOrangeObjectController {

    private final OrangeObjectService orangeObjectService;

    @GetMapping("/orangeobjects")
    public List<OrangeObjectResponse> getOrangeObjects() {
        return orangeObjectService.getAll().stream().map(OrangeObjectResponse::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/orangeobjects")
    public OrangeObjectResponse create(@RequestBody OrangeObjectCreateRequest orangeObjectCreateRequest) {

        var dto = OrangeObjectCreateDto.builder()
                .name(orangeObjectCreateRequest.getName())
                .description(orangeObjectCreateRequest.getDescription())
                .size(orangeObjectCreateRequest.getSize())
                .type(orangeObjectCreateRequest.getType())
                .build();

        var created = orangeObjectService.create(dto);

        return Objects.isNull(created) ? null : new OrangeObjectResponse(created);
    }

    @PutMapping(value = "/orangeobjects/{id}")
    public OrangeObjectResponse update(@RequestBody OrangeObjectUpdateRequest orangeObjectUpdateRequest, @PathVariable("id") Long id) {

        var dto = OrangeObjectUpdateDto.builder()
                .id(id)
                .name(orangeObjectUpdateRequest.getName())
                .description(orangeObjectUpdateRequest.getDescription())
                .size(orangeObjectUpdateRequest.getSize())
                .type(orangeObjectUpdateRequest.getType())
                .build();

        var updated = orangeObjectService.update(dto);

        return Objects.isNull(updated) ? null : new OrangeObjectResponse(updated);
    }

    @DeleteMapping(value = "/orangeobjects/{id}")
    public void delete(@PathVariable("id") Long id) {
        orangeObjectService.delete(id);
    }

}
