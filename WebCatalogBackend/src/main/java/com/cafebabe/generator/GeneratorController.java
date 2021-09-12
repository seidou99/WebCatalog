package com.cafebabe.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class GeneratorController {

    @Autowired
    protected ManufacturerTypeGenerator manufacturerTypeGenerator;

    @Autowired
    protected ManufacturerGenerator manufacturerGenerator;

    @Autowired
    protected OperationSystemGenerator operationSystemGenerator;

    @Autowired
    protected ScreenTechnologyGenerator screenTechnologyGenerator;

    @Autowired
    protected ColorGenerator colorGenerator;

    @Autowired
    protected FingerprintScannerLocationGenerator fingerprintScannerLocationGenerator;

    @Autowired
    protected ScreenProtectionGenerator screenProtectionGenerator;

    @Autowired
    protected PhoneGpuGenerator phoneGpuGenerator;

    @Autowired
    protected PhoneCpuGenerator phoneCpuGenerator;

    @Autowired
    protected SimCardTypeGenerator simCardTypeGenerator;

    @Autowired
    protected DustAndMoistureProtectionGenerator dustAndMoistureProtectionGenerator;

    @Autowired
    protected ConnectionSocketGenerator connectionSocketGenerator;

    @Autowired
    protected PhoneModelGenerator phoneModelGenerator;

    @GetMapping("api/generator/all")
    public void generateAll() {
        Arrays.asList(manufacturerTypeGenerator, manufacturerGenerator, operationSystemGenerator, screenTechnologyGenerator, colorGenerator, fingerprintScannerLocationGenerator, screenProtectionGenerator, phoneGpuGenerator, phoneCpuGenerator, simCardTypeGenerator, dustAndMoistureProtectionGenerator, connectionSocketGenerator, phoneModelGenerator).forEach(GeneratorService::generate);
    }

    @GetMapping("api/generator/manufacturer")
    public void generateManufacturers() {
        manufacturerGenerator.generate();
    }

    @GetMapping("api/generator/mobile/os")
    public void generateMobileOs() {
        operationSystemGenerator.generate();
    }

    @GetMapping("api/generator/screen-technology")
    public void generateScreenTechnologies() {
        screenTechnologyGenerator.generate();
    }

    @GetMapping("api/generator/color")
    public void generateColors() {
        colorGenerator.generate();
    }

}
