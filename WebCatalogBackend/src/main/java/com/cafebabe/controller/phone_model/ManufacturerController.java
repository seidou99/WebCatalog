package com.cafebabe.controller.phone_model;

import com.cafebabe.entity.Manufacturer;
import com.cafebabe.service.interfaces.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManufacturerController {

    @Autowired
    protected ManufacturerService manufacturerService;

    @PostMapping("api/manufacturers")
    public void save(@RequestBody Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
    }

    @GetMapping("api/manufacturers")
    public List<Manufacturer> getAll() {
        return manufacturerService.findAll();
    }
}
