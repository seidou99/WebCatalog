package com.cafebabe.controller.phone_model;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.entity.PhoneModel;
import com.cafebabe.service.interfaces.PhoneModelFilterService;
import com.cafebabe.service.interfaces.PhoneModelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@Getter
@Setter
public class PhoneModelController {

    @Autowired
    protected PhoneModelService phoneModelService;

    @Autowired
    protected PhoneModelFilterService phoneModelFilterService;

    @GetMapping("/api/phones/models/filter")
    protected PhoneModelFilterDto getPhoneModelFilter() {
        return phoneModelFilterService.loadPhoneModelFilterPossibleValues();
    }

    @GetMapping("api/phones/models")
    public List<PhoneModel> findAll() {
        return phoneModelService.findAll();
    }

    @PostMapping(value = "api/phones/models", consumes = {MediaType.ALL_VALUE})
    public void save(@ModelAttribute(name = "images") List<MultipartFile> images, @ModelAttribute(name = "phoneModelJson") String phoneModelJson) throws IOException {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        PhoneModel phoneModel = objectMapper.readValue(phoneModelJson, PhoneModel.class);
        phoneModelService.save(phoneModel, images);
    }

    @GetMapping("api/phones/models/{id}")
    public PhoneModel findById(@PathVariable BigInteger id) {
        Optional<PhoneModel> phoneModel = phoneModelService.findById(id);
        return phoneModel.orElse(null);
    }

    @PostMapping("api/phones/models/filtered")
    public List<PhoneModel> findFilteredPhoneModels(@RequestBody PhoneModelFilterDto filterDto, @RequestParam int pageIndex, @RequestParam int pageSize) {
        return phoneModelService.findFilteredPhoneModelsWithPagination(filterDto, pageIndex, pageSize);
    }

    @PostMapping("api/phones/models/filtered/count")
    public Long findFilteredPhoneModelsCount(@RequestBody PhoneModelFilterDto filterDto) {
        Long filteredPhoneModelsCount = phoneModelService.findFilteredPhoneModelsCount(filterDto);
        return filteredPhoneModelsCount;
    }
}
