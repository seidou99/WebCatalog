package com.cafebabe.controller.phone_model;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.entity.mobilephone.PhoneModel;
import com.cafebabe.service.interfaces.PhoneModelFilterService;
import com.cafebabe.service.interfaces.RamAndRomVariantService;
import com.cafebabe.service.mobilephone.interfaces.PhoneModelService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("api/phones/models")
    public void save(@RequestBody PhoneModel phoneModel) {
        phoneModelService.save(phoneModel);
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
