package com.cafebabe.generator;

import com.cafebabe.entity.FingerprintScannerLocation;
import com.cafebabe.service.interfaces.FingerprintScannerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FingerprintScannerLocationGenerator implements GeneratorService {

    @Autowired
    protected FingerprintScannerLocationService fingerprintScannerLocationService;

    public void generate() {
        GeneratorConstants.FingerprintScannerLocations.ALL.forEach(location -> {
            if (!fingerprintScannerLocationService.findByName(location.getName()).isPresent()) {
                fingerprintScannerLocationService.save(location);
            }
        });
    }
}
