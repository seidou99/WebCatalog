package com.cafebabe.controller.mobilephone;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.entity.mobilephone.PhoneModel;
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
    protected RamAndRomVariantService ramAndRomVariantService;

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
    public List<PhoneModel> findFilteredModels(@RequestBody PhoneModelFilterDto filterDto) {
        return phoneModelService.findFilteredPhoneModels(filterDto);
    }
}
