package com.cafebabe.controller;

import com.cafebabe.entity.SimCardType;
import com.cafebabe.service.interfaces.SimCardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimCardTypeController {

    @Autowired
    protected SimCardTypeService simCardTypeService;

    @PostMapping("api/sim-card-types")
    public void save(@RequestBody SimCardType simCardType) {
        simCardTypeService.save(simCardType);
    }

    @GetMapping("api/sim-card-types")
    public List<SimCardType> getAll() {
        return simCardTypeService.findAll();
    }
}
