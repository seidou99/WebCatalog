package com.cafebabe.controller.mobilephone;

import com.cafebabe.entity.DustAndMoistureProtection;
import com.cafebabe.service.interfaces.DustAndMoistureProtectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DustAndMoistureProtectionController {

    @Autowired
    protected DustAndMoistureProtectionService dustAndMoistureProtectionService;

    @PostMapping("api/dust-and-moisture-protections")
    public void save(@RequestBody DustAndMoistureProtection dustAndMoistureProtection) {
        dustAndMoistureProtectionService.save(dustAndMoistureProtection);
    }

    @GetMapping("api/dust-and-moisture-protections")
    public List<DustAndMoistureProtection> getAll() {
        return dustAndMoistureProtectionService.findAll();
    }
}
