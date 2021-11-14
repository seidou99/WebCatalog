package com.cafebabe;

import com.cafebabe.service.interfaces.PhoneGpuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
@TestComponent
public class PhoneGpuServiceTest {

    @Autowired
    protected PhoneGpuService phoneGpuService;

    @Test
    public void testCreate() {
        PhoneGpus.ALL.forEach(phoneGpu -> {
            if (!phoneGpuService.findByName(phoneGpu.getName()).isPresent()) {
                phoneGpuService.save(phoneGpu);
            }
        });
    }
}
