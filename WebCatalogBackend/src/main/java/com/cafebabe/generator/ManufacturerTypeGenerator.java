package com.cafebabe.generator;

import com.cafebabe.service.interfaces.ManufacturerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerTypeGenerator implements GeneratorService {

    @Autowired
    protected ManufacturerTypeService manufacturerTypeService;

    public void generate() {
        GeneratorConstants.ManufacturerTypes.ALL.forEach(manufacturerType -> {
            if (!manufacturerTypeService.findByName(manufacturerType.getName()).isPresent()) {
                manufacturerTypeService.save(manufacturerType);
            }
        });
    }
}
