package com.cafebabe.generator;

import com.cafebabe.entity.ScreenProtection;
import com.cafebabe.service.interfaces.ScreenProtectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenProtectionGenerator implements GeneratorService {

    @Autowired
    protected ScreenProtectionService screenProtectionService;

    public void generate() {
        GeneratorConstants.ScreenProtections.ALL.forEach(screenProtection -> {
            if (!screenProtectionService.findByName(screenProtection.getName()).isPresent()) {
                screenProtectionService.save(screenProtection);
            }
        });
    }
}
