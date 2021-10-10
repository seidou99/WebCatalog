package com.cafebabe;

import com.cafebabe.generator.GeneratorConstants;
import com.cafebabe.service.interfaces.FingerprintScannerLocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FingerprintScannerLocationServiceTest {

    @Autowired
    protected FingerprintScannerLocationService fingerprintScannerLocationService;

    @Test
    public void testCreate() {
        FingerprintScannerLocations.ALL.forEach(location -> {
            if (!fingerprintScannerLocationService.findByName(location.getName()).isPresent()) {
                fingerprintScannerLocationService.save(location);
            }
        });
    }
}
