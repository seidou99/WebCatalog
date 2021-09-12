package com.cafebabe.generator;

import com.cafebabe.service.interfaces.PhoneGpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneGpuGenerator implements GeneratorService {

    @Autowired
    protected PhoneGpuService phoneGpuService;

    public void generate() {
        GeneratorConstants.PhoneGpus.ALL.forEach(phoneGpu -> {
            if (!phoneGpuService.findByName(phoneGpu.getName()).isPresent()) {
                phoneGpuService.save(phoneGpu);
            }
        });
    }
}
