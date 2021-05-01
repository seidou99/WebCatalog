package com.cafebabe.controller.mobilephone;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.service.interfaces.PhoneModelFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneModelFilterController {

    @Autowired
    protected PhoneModelFilterService phoneModelFilterService;

    @GetMapping("/api/phones/models/filter")
    protected PhoneModelFilterDto getPhoneModelFilter() {
        return phoneModelFilterService.loadPhoneModelFilter();
    }
}
