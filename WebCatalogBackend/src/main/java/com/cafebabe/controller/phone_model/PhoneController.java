package com.cafebabe.controller.phone_model;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.entity.Phone;
import com.cafebabe.service.interfaces.PhoneFilterService;
import com.cafebabe.service.mobilephone.interfaces.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class PhoneController {

    @Autowired
    protected PhoneService phoneService;

    @Autowired
    protected PhoneFilterService phoneFilterService;

    @GetMapping("/api/phones/filter")
    protected PhoneFilterDto getPhoneFilter() {
        return phoneFilterService.loadPhoneFilterPossibleValues();
    }

    @GetMapping("api/phones")
    public List<Phone> findAll() {
        return phoneService.findAll();
    }

    @PostMapping("api/phones")
    public void save(@RequestBody Phone phone) {
        phoneService.save(phone);
    }

    @GetMapping("api/phones/{id}")
    public Phone findById(@PathVariable BigInteger id) {
        Optional<Phone> phoneModel = phoneService.findById(id);
        return phoneModel.orElse(null);
    }

    @PostMapping("api/phones/filtered")
    public List<Phone> findFilteredPhoneModels(@RequestBody PhoneFilterDto filterDto, @RequestParam int pageIndex, @RequestParam int pageSize) {
        return phoneService.findFilteredPhoneModels(filterDto, pageIndex, pageSize);
    }
//
//    @PostMapping("api/phones/models/filtered/count")
//    public Long findFilteredPhoneModelsCount(@RequestBody PhoneModelFilterDto filterDto) {
//        return phoneModelService.findFilteredPhoneModelsCount(filterDto);
//    }
}
