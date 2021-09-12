package com.cafebabe.generator;

import com.cafebabe.entity.Color;
import com.cafebabe.service.interfaces.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorGenerator implements GeneratorService{

    @Autowired
    protected ColorService colorService;

    public void generate() {
        GeneratorConstants.Colors.ALL.forEach(color -> {
            if (!colorService.findByName(color.getName()).isPresent()) {
                colorService.save(color);
            }
        });
    }
}
