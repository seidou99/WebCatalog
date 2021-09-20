package com.cafebabe.generator;

import com.cafebabe.entity.Image;
import com.cafebabe.entity.OperationSystemWithVersion;
//import com.cafebabe.entity.PhoneModel;
import com.cafebabe.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PhoneModelGenerator implements GeneratorService {

//    @Autowired
//    protected PhoneModelService phoneModelService;

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

    public void generate() {
//        GeneratorConstants.PhoneModels.ALL.forEach(phoneModel -> {
//            if (phoneModelService.findByName(phoneModel.getName()).isPresent()) {
//                return;
//            }
//            String manufacturerName = phoneModel.getManufacturer().getName();
//            phoneModel.setManufacturer(manufacturerService.findByName(manufacturerName).orElseThrow(() -> new IllegalArgumentException("Manufacturer with manufacturerName '" + manufacturerName + "' not found")));
//            OperationSystemWithVersion operationSystemWithVersion = phoneModel.getOperationSystemWithVersion();
//            String operationSystemName = operationSystemWithVersion.getOperationSystem().getName();
//            String operationSystemVersion = operationSystemWithVersion.getVersion();
//            phoneModel.setOperationSystemWithVersion(operationSystemWithVersionService.findByOperationSystemNameAndVersion(operationSystemName, operationSystemVersion).orElseThrow(() -> new IllegalArgumentException("Operation system with name '" + operationSystemName + "' and version '" + operationSystemVersion + "' not found")));
//            String screenTechnologyName = phoneModel.getScreenTechnology().getName();
//            phoneModel.setScreenTechnology(screenTechnologyService.findByName(screenTechnologyName).orElseThrow(() -> new IllegalArgumentException("Screen technology with name '" + screenTechnologyName + "' not found")));
//            String scannerLocationName = phoneModel.getFingerprintScannerLocation().getName();
//            phoneModel.setFingerprintScannerLocation(fingerprintScannerLocationService.findByName(scannerLocationName).orElseThrow(() -> new IllegalArgumentException("Fingerprint scanner location with name '" + scannerLocationName + "'")));
//            String simCardTypeName = phoneModel.getSimCardType().getName();
//            phoneModel.setSimCardType(simCardTypeService.findByName(simCardTypeName).orElseThrow(() -> new IllegalArgumentException("Sim card type with name '" + simCardTypeName + "' not found")));
//            String phoneCpuName = phoneModel.getCpu().getName();
//            phoneModel.setCpu(phoneCpuService.findByName(phoneCpuName).orElseThrow(() -> new IllegalArgumentException("Phone cpu with name '" + phoneCpuName + "' not found")));
//            String connectionSocketName = phoneModel.getConnectionSocket().getName();
//            phoneModel.setConnectionSocket(connectionSocketService.findByName(connectionSocketName).orElseThrow(() -> new IllegalArgumentException("Connection socket with name '" + connectionSocketName + "' not found")));
//            phoneModel.setBodyColors(phoneModel.getBodyColors().stream().map(color -> colorService.findByName(color.getName()).orElseThrow(() -> new IllegalArgumentException("Color with name '" + color.getName() + "' not found"))).collect(Collectors.toList()));
//            if (phoneModel.getDustAndMoistureProtection() != null) {
//                String dustAndMoistureProtectionName = phoneModel.getDustAndMoistureProtection().getName();
//                phoneModel.setDustAndMoistureProtection(dustAndMoistureProtectionService.findByName(dustAndMoistureProtectionName).orElseThrow(() -> new IllegalArgumentException("Dust and moisture protection with name '" + dustAndMoistureProtectionName + "' not found")));
//            }
//            if (phoneModel.getScreenProtection() != null) {
//                String screenProtectionName = phoneModel.getScreenProtection().getName();
//                phoneModel.setScreenProtection(screenProtectionService.findByName(screenProtectionName).orElseThrow(() -> new IllegalArgumentException("Screen protection with name '" + screenProtectionName + "' not found")));
//            }
//            getImagesForPhoneModel(phoneModel);
//            try {
//                phoneModelService.save(phoneModel, getImagesForPhoneModel(phoneModel));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
    }

//    protected List<MultipartFile> getImagesForPhoneModel(PhoneModel phoneModel) {
//        String imagesDirectoryPath = GeneratorConstants.PhoneModels.PHONE_MODEL_TO_IMAGES_DIRECTORY_MAP.entrySet().stream().filter(entry -> entry.getKey().getName().equals(phoneModel.getName())).map(Map.Entry::getValue).findFirst().orElseThrow(() -> new IllegalArgumentException("Images directory for phone model '" + phoneModel.getName() + "' not found"));
//        String currentDirectory = System.getProperty("user.dir");
//        String imagesDirectoryFullPath = currentDirectory + File.separator + GeneratorConstants.GENERATOR_IMAGES_DIRECTORY + File.separator + imagesDirectoryPath;
//        File directoryFile = new File(imagesDirectoryFullPath);
//        File[] files = directoryFile.listFiles();
//        List<MultipartFile> mockMultipartFiles = new ArrayList<>();
//        assert files != null;
//        for (File file : files) {
//            if (file.isFile()) {
//                mockMultipartFiles.add(createMockFile(file));
//            } else {
//                for (File listFile : file.listFiles()) {
//                    mockMultipartFiles.add(createMockFile(listFile));
//                }
//            }
//        }
//        return mockMultipartFiles;
//    }
//
//    protected MultipartFile createMockFile(File file) {
//        try {
//            return new MockMultipartFile(file.getName(), file.getName(), null, Files.readAllBytes(Paths.get(file.toURI())));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
