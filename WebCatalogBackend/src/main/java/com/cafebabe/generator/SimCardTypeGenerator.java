package com.cafebabe.generator;

import com.cafebabe.service.interfaces.SimCardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimCardTypeGenerator implements GeneratorService {

    @Autowired
    protected SimCardTypeService simCardTypeService;

    public void generate() {
        GeneratorConstants.SimCardTypes.ALL.forEach(simCardType -> {
            if (!simCardTypeService.findByName(simCardType.getName()).isPresent()) {
                simCardTypeService.save(simCardType);
            }
        });
    }
}
