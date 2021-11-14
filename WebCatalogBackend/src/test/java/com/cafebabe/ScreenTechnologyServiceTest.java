package com.cafebabe;

import com.cafebabe.service.interfaces.ScreenTechnologyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
@TestComponent
public class ScreenTechnologyServiceTest {

    @Autowired
    protected ScreenTechnologyService screenTechnologyService;

    @Test
    public void testGenerate() {
        ScreenTechnologies.ALL.forEach(screenTechnology -> {
            if (!screenTechnologyService.findByName(screenTechnology.getName()).isPresent()) {
                screenTechnologyService.save(screenTechnology);
            }
        });
    }
}
