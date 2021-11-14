package com.cafebabe;

import com.cafebabe.service.interfaces.ManufacturerService;
import com.cafebabe.service.interfaces.ManufacturerTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.stream.Collectors;

@SpringBootTest
@TestComponent
public class ManufacturerServiceTest {

    @Autowired
    protected ManufacturerService manufacturerService;

    @Autowired
    protected ManufacturerTypeService manufacturerTypeService;

    @Test
    public void testCreateManufacturers() {
        Manufacturers.ManufacturerTypes.ALL.forEach(manufacturerType -> {
            if (!manufacturerTypeService.findByName(manufacturerType.getName()).isPresent()) {
                manufacturerTypeService.save(manufacturerType);
            }
        });
        Manufacturers.ALL.forEach(manufacturer -> {
            manufacturer.setManufacturerTypes(manufacturer.getManufacturerTypes().stream().map(manufacturerType -> manufacturerTypeService.findByName(manufacturerType.getName()).orElseThrow(() -> new IllegalArgumentException("Manufacturer type with name '" + manufacturerType.getName() + "' not found"))).collect(Collectors.toList()));
            if (!manufacturerService.findByName(manufacturer.getName()).isPresent()) {
                manufacturerService.save(manufacturer);
            }
        });
    }
}
