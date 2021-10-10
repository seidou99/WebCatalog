package com.cafebabe;

import com.cafebabe.entity.phone.PhoneGpu;
import com.cafebabe.generator.GeneratorConstants;
import com.cafebabe.service.interfaces.PhoneCpuService;
import com.cafebabe.service.interfaces.PhoneGpuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class PhoneCpuServiceTest {

    @Autowired
    protected PhoneCpuService phoneCpuService;

    @Autowired
    protected PhoneGpuService phoneGpuService;

    @Test
    public void testCreate() {
        PhoneCpus.ALL.forEach(cpu -> {
            if (!phoneCpuService.findByName(cpu.getName()).isPresent()) {
                Optional<PhoneGpu> gpuByName = phoneGpuService.findByName(cpu.getIntegratedGpu().getName());
                cpu.setIntegratedGpu(gpuByName.orElseThrow(() -> new IllegalArgumentException("Phone gpu with name '" + cpu.getIntegratedGpu().getName() + "' not found")));
                phoneCpuService.save(cpu);
            }
        });
    }
}
