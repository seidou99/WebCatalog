package com.cafebabe.controller.phone_model;

import com.cafebabe.entity.FingerprintScannerLocation;
import com.cafebabe.service.interfaces.FingerprintScannerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FingerprintScannerLocationController {

    @Autowired
    protected FingerprintScannerLocationService fingerprintScannerLocationService;

    @PostMapping("api/fingerprint-scanner-locations")
    public void save(@RequestBody FingerprintScannerLocation fingerprintScannerLocation) {
        fingerprintScannerLocationService.save(fingerprintScannerLocation);
    }

    @GetMapping("api/fingerprint-scanner-locations")
    public List<FingerprintScannerLocation> getAll() {
        return fingerprintScannerLocationService.findAll();
    }
}
