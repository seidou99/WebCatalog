package com.cafebabe.generator;

import com.cafebabe.service.interfaces.ManufacturerService;
import com.cafebabe.service.interfaces.ManufacturerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ManufacturerGenerator implements GeneratorService {

    @Autowired
    protected ManufacturerService manufacturerService;

    @Autowired
    protected ManufacturerTypeService manufacturerTypeService;

    public void generate() {
        GeneratorConstants.Manufacturers.ALL.forEach(manufacturer -> {
            manufacturer.setManufacturerTypes(manufacturer.getManufacturerTypes().stream().map(manufacturerType -> manufacturerTypeService.findByName(manufacturerType.getName()).orElseThrow(() -> new IllegalArgumentException("Manufacturer type with name '" + manufacturerType.getName() + "' not found"))).collect(Collectors.toList()));
            if (!manufacturerService.findByName(manufacturer.getName()).isPresent()) {
                manufacturerService.save(manufacturer);
            }
        });
    }
}
