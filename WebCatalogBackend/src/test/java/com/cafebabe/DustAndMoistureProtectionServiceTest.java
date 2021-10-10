package com.cafebabe;

import com.cafebabe.generator.GeneratorConstants;
import com.cafebabe.service.interfaces.DustAndMoistureProtectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DustAndMoistureProtectionServiceTest {

    @Autowired
    protected DustAndMoistureProtectionService service;

    @Test
    public void testCreate() {
        DustAndMoistureProtectionTypes.ALL.forEach(protection -> {
            if (!service.findByName(protection.getName()).isPresent()) {
                service.save(protection);
            }
        });
    }
}
