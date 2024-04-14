package com.example.pracadomowa.controller;

import com.example.pracadomowa.controller.model.orangeobject.OrangeObjectCreateRequest;
import com.example.pracadomowa.controller.model.orangeobject.OrangeObjectResponse;
import com.example.pracadomowa.controller.model.orangeobject.OrangeObjectUpdateRequest;
import com.example.pracadomowa.service.orangeobject.OrangeObjectService;
import com.example.pracadomowa.service.orangeobject.dto.OrangeObjectCreateDto;
import com.example.pracadomowa.service.orangeobject.dto.OrangeObjectUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/orange")
@AllArgsConstructor
public class ApiOrangeObjectController {

    private final OrangeObjectService orangeObjectService;

    @GetMapping("/objects")
    public List<OrangeObjectResponse> getOrangeObjects() {
        return orangeObjectService.getAll().stream().map(OrangeObjectResponse::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/objects")
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

    @PutMapping(value = "/objects/{id}")
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

    @DeleteMapping(value = "/objects/{id}")
    public void delete(@PathVariable("id") Long id) {
        orangeObjectService.delete(id);
    }

}
