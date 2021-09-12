package com.cafebabe.generator;

import com.cafebabe.entity.PhoneGpu;
import com.cafebabe.service.interfaces.PhoneCpuService;
import com.cafebabe.service.interfaces.PhoneGpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneCpuGenerator implements GeneratorService {

    @Autowired
    protected PhoneCpuService phoneCpuService;

    @Autowired
    protected PhoneGpuService phoneGpuService;

    public void generate() {
        GeneratorConstants.PhoneCpus.ALL.forEach(cpu -> {
            if (!phoneCpuService.findByName(cpu.getName()).isPresent()) {
                Optional<PhoneGpu> gpuByName = phoneGpuService.findByName(cpu.getIntegratedGpu().getName());
                cpu.setIntegratedGpu(gpuByName.orElseThrow(() -> new IllegalArgumentException("Phone gpu with name '" + cpu.getIntegratedGpu().getName() + "' not found")));
                phoneCpuService.save(cpu);
            }
        });
    }
}
