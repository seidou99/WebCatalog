package com.cafebabe;

import com.cafebabe.entity.Color;
import com.cafebabe.entity.OperationSystemWithVersion;
import com.cafebabe.entity.phone.Phone;
import com.cafebabe.service.interfaces.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestComponent
public class PhoneServiceTest {

    @Autowired
    protected ManufacturerService manufacturerService;

    @Autowired
    protected OperationSystemWithVersionService operationSystemWithVersionService;

    @Autowired
    protected FingerprintScannerLocationService fingerprintScannerLocationService;

    @Autowired
    protected SimCardTypeService simCardTypeService;

    @Autowired
    protected PhoneCpuService phoneCpuService;

    @Autowired
    protected ConnectionSocketService connectionSocketService;

    @Autowired
    protected ColorService colorService;

    @Autowired
    protected DustAndMoistureProtectionService dustAndMoistureProtectionService;

    @Autowired
    protected ScreenProtectionService screenProtectionService;

    @Autowired
    protected ScreenTechnologyService screenTechnologyService;

    @Autowired
    protected PhoneService phoneService;

    @Test
    public void testCreate() {
        Phones.ALL.forEach(phone -> {
            if (phoneService.findByName(phone.getName()).isPresent()) {
                return;
            }
            String manufacturerName = phone.getManufacturer().getName();
            phone.setManufacturer(manufacturerService.findByName(manufacturerName).orElseThrow(() -> new IllegalArgumentException("Manufacturer with manufacturerName '" + manufacturerName + "' not found")));
            OperationSystemWithVersion operationSystemWithVersion = phone.getOperationSystemWithVersion();
            String operationSystemName = operationSystemWithVersion.getOperationSystem().getName();
            String operationSystemVersion = operationSystemWithVersion.getVersion();
            phone.setOperationSystemWithVersion(operationSystemWithVersionService.findByOperationSystemNameAndVersion(operationSystemName, operationSystemVersion).orElseThrow(() -> new IllegalArgumentException("Operation system with name '" + operationSystemName + "' and version '" + operationSystemVersion + "' not found")));
            String screenTechnologyName = phone.getScreenTechnology().getName();
            phone.setScreenTechnology(screenTechnologyService.findByName(screenTechnologyName).orElseThrow(() -> new IllegalArgumentException("Screen technology with name '" + screenTechnologyName + "' not found")));
            String scannerLocationName = phone.getFingerprintScannerLocation().getName();
            phone.setFingerprintScannerLocation(fingerprintScannerLocationService.findByName(scannerLocationName).orElseThrow(() -> new IllegalArgumentException("Fingerprint scanner location with name '" + scannerLocationName + "'")));
            String simCardTypeName = phone.getSimCardType().getName();
            phone.setSimCardType(simCardTypeService.findByName(simCardTypeName).orElseThrow(() -> new IllegalArgumentException("Sim card type with name '" + simCardTypeName + "' not found")));
            String phoneCpuName = phone.getCpu().getName();
            phone.setCpu(phoneCpuService.findByName(phoneCpuName).orElseThrow(() -> new IllegalArgumentException("Phone cpu with name '" + phoneCpuName + "' not found")));
            String connectionSocketName = phone.getConnectionSocket().getName();
            phone.setConnectionSocket(connectionSocketService.findByName(connectionSocketName).orElseThrow(() -> new IllegalArgumentException("Connection socket with name '" + connectionSocketName + "' not found")));
            String bodyColorName = phone.getBodyColor().getName();
            Optional<Color> bodyColor = colorService.findByName(bodyColorName);
            if (bodyColor.isPresent()) {
                phone.setBodyColor(bodyColor.get());
            } else {
                throw new IllegalArgumentException("Color with name '" + bodyColorName + "' not found");
            }
            if (phone.getDustAndMoistureProtection() != null) {
                String dustAndMoistureProtectionName = phone.getDustAndMoistureProtection().getName();
                phone.setDustAndMoistureProtection(dustAndMoistureProtectionService.findByName(dustAndMoistureProtectionName).orElseThrow(() -> new IllegalArgumentException("Dust and moisture protection with name '" + dustAndMoistureProtectionName + "' not found")));
            }
            if (phone.getScreenProtection() != null) {
                String screenProtectionName = phone.getScreenProtection().getName();
                phone.setScreenProtection(screenProtectionService.findByName(screenProtectionName).orElseThrow(() -> new IllegalArgumentException("Screen protection with name '" + screenProtectionName + "' not found")));
            }
//            phoneService.save(phone);
//            getImagesForPhone(phone);
            List<MultipartFile> imagesForPhone = getImagesForPhone(phone);
            MultipartFile mainImage = imagesForPhone.get(0);
            try {
                phoneService.save(phone, mainImage, imagesForPhone);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    protected List<MultipartFile> getImagesForPhone(Phone phone) {
        String directory = Phones.PHONE_TO_IMAGES_DIRECTORY_MAP.get(phone);
        if (directory == null) {
            throw new IllegalArgumentException("Image directory for phone " + phone.getName() + "not found");
        }
        String currentDirectory = System.getProperty("user.dir");
        String imagesDirectoryFullPath = currentDirectory + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "phone_images" + File.separator + directory;
        File directoryFile = new File(imagesDirectoryFullPath);
        File[] files = directoryFile.listFiles();
        List<MultipartFile> mockMultipartFiles = new ArrayList<>();
        assert files != null;
        for (File file : files) {
            mockMultipartFiles.add(createMockFile(file));
        }
        return mockMultipartFiles;
    }

    protected MultipartFile createMockFile(File file) {
        try {
            return new MockMultipartFile(file.getName(), file.getName(), null, Files.readAllBytes(Paths.get(file.toURI())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
