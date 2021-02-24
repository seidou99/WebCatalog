package com.cafebabe.controller.mobilephone;

import com.cafebabe.model.BaseDataObject;
import com.cafebabe.model.mobilephone.MobilePhoneManufacturer;
import com.cafebabe.service.impl.MobilePhoneManufacturerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MobilePhoneManufacturerController {

    @Autowired
    protected MobilePhoneManufacturerServiceImpl manufacturerService;

    @PostMapping("api/phones/manufacturers")
    public void create(@RequestBody MobilePhoneManufacturer manufacturer) {
        manufacturerService.save(manufacturer);
    }

    @GetMapping("api/phones/manufacturers")
    public List<MobilePhoneManufacturer> getAll() {
        return manufacturerService.findAll();
    }
}
