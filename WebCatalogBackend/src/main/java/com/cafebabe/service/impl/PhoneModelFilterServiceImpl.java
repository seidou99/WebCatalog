package com.cafebabe.service.impl;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.service.interfaces.*;
import com.cafebabe.service.mobilephone.interfaces.ManufacturerService;
import com.cafebabe.service.mobilephone.interfaces.OperationSystemWithVersionService;
import com.cafebabe.service.mobilephone.interfaces.PhoneModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.stream.Stream;

@Service
public class PhoneModelFilterServiceImpl implements PhoneModelFilterService {

    @Autowired
    protected ManufacturerService manufacturerService;

    @Autowired
    protected PhoneModelService phoneModelService;

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
    protected RamAndRomVariantService ramAndRomVariantService;

    @Autowired
    protected ConnectionSocketService connectionSocketService;

    @Override
    public PhoneModelFilterDto loadPhoneModelFilterPossibleValues() {
        Stream<Consumer<PhoneModelFilterDto>> loadFilterCallbackStream = Stream.of(
                filter -> filter.setManufacturers(manufacturerService.findAll()),
                filter -> filter.setMarketLaunchYears(phoneModelService.findDistinctMarketLaunchYears()),
                filter -> filter.setOperationSystemsWithVersions(operationSystemWithVersionService.findAll()),
                filter -> filter.setScreenDiagonalsInInches(phoneModelService.findDistinctScreenDiagonals()),
                filter -> filter.setScreenResolutions(phoneModelService.findDistinctScreenResolutions()),
                filter -> filter.setScreenRefreshRates(phoneModelService.findDistinctScreenRefreshRates()),
                filter -> filter.setRamVariants(ramAndRomVariantService.findDistinctRamVariants()),
                filter -> filter.setRomVariants(ramAndRomVariantService.findDistinctRomVariants()),
                filter -> filter.setCamerasAmountVariants(phoneModelService.findDistinctCamerasAmountVariants()),
                filter -> filter.setCamerasInMp(phoneModelService.findDistinctCamerasInMp()),
                filter -> filter.setSimCardsAmountVariants(phoneModelService.findDistinctSimCardsAmountVariants()),
                filter -> filter.setSimCardTypes(simCardTypeService.findAll()),
                filter -> filter.setBodyColors(colorService.findAll()),
                filter -> filter.setDustAndMoistureProtections(dustAndMoistureProtectionService.findAll()),
                filter -> filter.setBatteryCapacities(phoneModelService.findDistinctBatteryCapacities()),
                filter -> filter.setFingerprintScannerLocations(fingerprintScannerLocationService.findAll()),
                filter -> filter.setScreenProtections(screenProtectionService.findAll()),
                filter -> filter.setCpuVariants(phoneCpuService.findAll()),
                filter -> filter.setPhoneGpuVariants(phoneGpuService.findAll()),
                filter -> filter.setCoresAmountVariants(phoneCpuService.findDistinctCoresAmountVariants()),
                filter -> filter.setCpuClockSpeedVariants(phoneCpuService.findDistinctCpuClockSpeedVariants()),
                filter -> filter.setCpuTechprocessVariants(phoneCpuService.findDistinctCpuTechprocessVariants()),
                filter -> filter.setFrontCameraVariants(phoneModelService.findDistinctFrontCameraVariants()),
                filter -> filter.setLengthVariants(phoneModelService.findDistinctLengthVariants()),
                filter -> filter.setWidthVariants(phoneModelService.findDistinctWidthVariants()),
                filter -> filter.setThicknessVariants(phoneModelService.findDistinctThicknessVariants()),
                filter -> filter.setWeightVariants(phoneModelService.findDistinctWeightVariants()),
                filter -> filter.setScreenTechnologies(screenTechnologyService.findAll()),
                filter -> filter.setConnectionSocketVariants(connectionSocketService.findAll())
        );
        PhoneModelFilterDto result = new PhoneModelFilterDto();
        loadFilterCallbackStream.parallel().forEach(callback -> callback.accept(result));
        return result;
    }
}
