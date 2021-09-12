package com.cafebabe.generator;

import com.cafebabe.entity.ScreenTechnology;
import com.cafebabe.service.interfaces.ScreenTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenTechnologyGenerator implements GeneratorService {

    @Autowired
    protected ScreenTechnologyService screenTechnologyService;

    public void generate() {
        GeneratorConstants.ScreenTechnologies.ALL.forEach(screenTechnology -> {
            if (!screenTechnologyService.findByName(screenTechnology.getName()).isPresent()) {
                screenTechnologyService.save(screenTechnology);
            }
        });
    }
}
