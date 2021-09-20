package com.cafebabe.dto;

import com.cafebabe.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PhoneFilterDto {

    protected BigDecimal minPrice, maxPrice;

    List<Manufacturer> manufacturers;
    List<Integer> marketLaunchYears;
    List<OperationSystemWithVersion> operationSystemsWithVersions;
    List<Float> screenDiagonalsInInches;
    List<ScreenResolutionDto> screenResolutions;
    List<ScreenTechnology> screenTechnologies;
    List<Integer> screenRefreshRates;
    List<Float> ramVariants;
    List<Float> romVariants;
    Boolean isMemoryCardSupported;
    List<Integer> camerasAmountVariants;
    List<Float> camerasInMp;
    List<Integer> simCardsAmountVariants;
    List<SimCardType> simCardTypes;
    List<Color> bodyColors;
    List<DustAndMoistureProtection> dustAndMoistureProtections;
    List<Integer> batteryCapacities;
    List<FingerprintScannerLocation> fingerprintScannerLocations;
    List<ScreenProtection> screenProtections;
    List<PhoneCpu> cpuVariants;
    List<PhoneGpu> phoneGpuVariants;
    List<Integer> coresAmountVariants;
    List<Integer> cpuClockSpeedVariants;
    List<Integer> cpuTechprocessVariants;
    List<Float> frontCameraVariants;
    Boolean hasAudioOutput;
    List<ConnectionSocket> connectionSocketVariants;
    List<Float> lengthVariants;
    List<Float> widthVariants;
    List<Float> thicknessVariants;
    List<Float> weightVariants;
}
