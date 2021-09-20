package com.cafebabe.service.impl;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.stream.Stream;

@Service
public class PhoneFilterServiceImpl implements PhoneFilterService {

    @Autowired
    protected ManufacturerService manufacturerService;

    @Autowired
    protected PhoneService phoneService;

    @Autowired
    protected OperationSystemWithVersionService operationSystemWithVersionService;

    @Autowired
    protected ScreenTechnologyService screenTechnologyService;

    @Autowired
    protected SimCardTypeService simCardTypeService;

    @Autowired
    protected ColorService colorService;

    @Autowired
    protected DustAndMoistureProtectionService dustAndMoistureProtectionService;

    @Autowired
    protected FingerprintScannerLocationService fingerprintScannerLocationService;

    @Autowired
    ScreenProtectionService screenProtectionService;

    @Autowired
    protected PhoneCpuService phoneCpuService;

    @Autowired
    protected PhoneGpuService phoneGpuService;

    @Autowired
    protected ConnectionSocketService connectionSocketService;

    @Override
    public PhoneFilterDto loadPhoneFilterPossibleValues() {
        Stream<Consumer<PhoneFilterDto>> loadFilterCallbackStream = Stream.of(
                filter -> filter.setManufacturers(manufacturerService.findAll()),
                filter -> filter.setMarketLaunchYears(phoneService.findDistinctMarketLaunchYears()),
                filter -> filter.setOperationSystemsWithVersions(operationSystemWithVersionService.findAll()),
                filter -> filter.setScreenDiagonalsInInches(phoneService.findDistinctScreenDiagonals()),
                filter -> filter.setScreenResolutions(phoneService.findDistinctScreenResolutions()),
                filter -> filter.setScreenRefreshRates(phoneService.findDistinctScreenRefreshRates()),
                filter -> filter.setRamVariants(phoneService.findDistinctRamVariants()),
                filter -> filter.setRomVariants(phoneService.findDistinctRomVariants()),
                filter -> filter.setCamerasAmountVariants(phoneService.findDistinctCamerasAmountVariants()),
                filter -> filter.setCamerasInMp(phoneService.findDistinctCamerasInMp()),
                filter -> filter.setSimCardsAmountVariants(phoneService.findDistinctSimCardsAmountVariants()),
                filter -> filter.setSimCardTypes(simCardTypeService.findAll()),
                filter -> filter.setBodyColors(colorService.findAll()),
                filter -> filter.setDustAndMoistureProtections(dustAndMoistureProtectionService.findAll()),
                filter -> filter.setBatteryCapacities(phoneService.findDistinctBatteryCapacities()),
                filter -> filter.setFingerprintScannerLocations(fingerprintScannerLocationService.findAll()),
                filter -> filter.setScreenProtections(screenProtectionService.findAll()),
                filter -> filter.setCpuVariants(phoneCpuService.findAll()),
                filter -> filter.setPhoneGpuVariants(phoneGpuService.findAll()),
                filter -> filter.setCoresAmountVariants(phoneCpuService.findDistinctCoresAmountVariants()),
                filter -> filter.setCpuClockSpeedVariants(phoneCpuService.findDistinctCpuClockSpeedVariants()),
                filter -> filter.setCpuTechprocessVariants(phoneCpuService.findDistinctCpuTechprocessVariants()),
                filter -> filter.setFrontCameraVariants(phoneService.findDistinctFrontCameraVariants()),
                filter -> filter.setLengthVariants(phoneService.findDistinctLengthVariants()),
                filter -> filter.setWidthVariants(phoneService.findDistinctWidthVariants()),
                filter -> filter.setThicknessVariants(phoneService.findDistinctThicknessVariants()),
                filter -> filter.setWeightVariants(phoneService.findDistinctWeightVariants()),
                filter -> filter.setScreenTechnologies(screenTechnologyService.findAll()),
                filter -> filter.setConnectionSocketVariants(connectionSocketService.findAll())
        );
        PhoneFilterDto result = new PhoneFilterDto();
        loadFilterCallbackStream.parallel().forEach(callback -> callback.accept(result));
        return result;
    }
}
