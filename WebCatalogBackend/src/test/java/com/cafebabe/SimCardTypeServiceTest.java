package com.cafebabe;

import com.cafebabe.service.interfaces.SimCardTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
@TestComponent
public class SimCardTypeServiceTest {

    @Autowired
    protected SimCardTypeService simCardTypeService;

    @Test
    public void testCreate() {
        SimCardTypes.ALL.forEach(simCardType -> {
            if (!simCardTypeService.findByName(simCardType.getName()).isPresent()) {
                simCardTypeService.save(simCardType);
            }
        });
    }
}
