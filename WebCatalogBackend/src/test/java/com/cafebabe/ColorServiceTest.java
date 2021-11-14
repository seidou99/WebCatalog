package com.cafebabe;

import com.cafebabe.service.interfaces.ColorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Component;

@SpringBootTest
@TestComponent
public class ColorServiceTest {

    @Autowired
    protected ColorService colorService;

    @Test
    public void testCreate() {
        Colors.ALL.forEach(color -> {
            if (!colorService.findByName(color.getName()).isPresent()) {
                colorService.save(color);
            }
        });
    }
}
