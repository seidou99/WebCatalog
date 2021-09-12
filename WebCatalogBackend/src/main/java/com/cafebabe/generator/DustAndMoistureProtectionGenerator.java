package com.cafebabe.generator;

import com.cafebabe.service.interfaces.DustAndMoistureProtectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DustAndMoistureProtectionGenerator implements GeneratorService{

    @Autowired
    protected DustAndMoistureProtectionService service;

    public void generate() {
        GeneratorConstants.DustAndMoistureProtectionTypes.ALL.forEach(protection -> {
            if (!service.findByName(protection.getName()).isPresent()) {
                service.save(protection);
            }
        });
    }
}
