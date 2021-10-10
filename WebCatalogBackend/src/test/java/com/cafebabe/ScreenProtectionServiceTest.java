package com.cafebabe;

import com.cafebabe.generator.GeneratorConstants;
import com.cafebabe.service.interfaces.ScreenProtectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScreenProtectionServiceTest {

    @Autowired
    protected ScreenProtectionService screenProtectionService;

    @Test
    public void testGenerate() {
        ScreenProtections.ALL.forEach(screenProtection -> {
            if (!screenProtectionService.findByName(screenProtection.getName()).isPresent()) {
                screenProtectionService.save(screenProtection);
            }
        });
    }
}
