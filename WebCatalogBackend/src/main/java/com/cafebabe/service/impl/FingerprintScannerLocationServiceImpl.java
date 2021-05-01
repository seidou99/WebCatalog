package com.cafebabe.service.impl;

import com.cafebabe.entity.FingerprintScannerLocation;
import com.cafebabe.repository.FingerprintScannerLocationRepository;
import com.cafebabe.service.interfaces.FingerprintScannerLocationService;
import org.springframework.stereotype.Service;

@Service
public class FingerprintScannerLocationServiceImpl extends BaseDataObjectServiceImpl<FingerprintScannerLocationRepository, FingerprintScannerLocation> implements FingerprintScannerLocationService {
}
