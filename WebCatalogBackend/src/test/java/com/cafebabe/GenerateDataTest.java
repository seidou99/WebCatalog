package com.cafebabe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest()
@Import({ColorServiceTest.class, ConnectionSocketServiceTest.class, DustAndMoistureProtectionServiceTest.class, FingerprintScannerLocationServiceTest.class, ManufacturerServiceTest.class, OperationSystemServiceTest.class,
        PhoneGpuServiceTest.class, PhoneCpuServiceTest.class, ScreenProtectionServiceTest.class, ScreenTechnologyServiceTest.class, SimCardTypeServiceTest.class, PhoneServiceTest.class, RolesTest.class})
public class GenerateDataTest {

    @Autowired
    ColorServiceTest colorServiceTest;
    @Autowired
    ConnectionSocketServiceTest connectionSocketServiceTest;
    @Autowired
    DustAndMoistureProtectionServiceTest dustAndMoistureProtectionServiceTest;
    @Autowired
    FingerprintScannerLocationServiceTest fingerprintScannerLocationServiceTest;
    @Autowired
    ManufacturerServiceTest manufacturerServiceTest;
    @Autowired
    OperationSystemServiceTest operationSystemServiceTest;
    @Autowired
    PhoneGpuServiceTest phoneGpuServiceTest;
    @Autowired
    PhoneCpuServiceTest phoneCpuServiceTest;
    @Autowired
    ScreenProtectionServiceTest screenProtectionServiceTest;
    @Autowired
    ScreenTechnologyServiceTest screenTechnologyServiceTest;
    @Autowired
    SimCardTypeServiceTest simCardTypeServiceTest;
    @Autowired
    PhoneServiceTest phoneServiceTest;
    @Autowired
    protected RolesTest rolesTest;

    @Test
    public void generateTestData() {
        colorServiceTest.testCreate();
        connectionSocketServiceTest.testCreate();
        dustAndMoistureProtectionServiceTest.testCreate();
        fingerprintScannerLocationServiceTest.testCreate();
        manufacturerServiceTest.testCreateManufacturers();
        operationSystemServiceTest.testCreate();
        phoneGpuServiceTest.testCreate();
        phoneCpuServiceTest.testCreate();
        screenProtectionServiceTest.testGenerate();
        screenTechnologyServiceTest.testGenerate();
        simCardTypeServiceTest.testCreate();
        phoneServiceTest.testCreate();
        rolesTest.testCreate();
        rolesTest.createDefaultAdmin();
    }
}
