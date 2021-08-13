package com.cafebabe.controller.phone_model;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.entity.Phone;
import com.cafebabe.entity.mobilephone.PhoneModel;
import com.cafebabe.service.interfaces.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
public class PhoneController {

    @Autowired
    protected PhoneService phoneService;

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

//    @PostMapping("api/phones/models/filtered")
//    public List<PhoneModel> findFilteredPhoneModels(@RequestBody PhoneModelFilterDto filterDto, @RequestParam int pageIndex, @RequestParam int pageSize) {
//        return phoneModelService.findFilteredPhoneModels(filterDto, pageIndex, pageSize);
//    }
//
//    @PostMapping("api/phones/models/filtered/count")
//    public Long findFilteredPhoneModelsCount(@RequestBody PhoneModelFilterDto filterDto) {
//        return phoneModelService.findFilteredPhoneModelsCount(filterDto);
//    }
}
