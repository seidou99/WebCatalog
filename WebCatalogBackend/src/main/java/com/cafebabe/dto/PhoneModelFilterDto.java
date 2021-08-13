package com.cafebabe.dto;

import com.cafebabe.entity.*;
import com.cafebabe.entity.mobilephone.OperationSystemWithVersion;
import com.cafebabe.entity.mobilephone.PhoneCpu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PhoneModelFilterDto {

    List<Manufacturer> manufacturers;
    List<Integer> marketLaunchYears;
    List<OperationSystemWithVersion> operationSystemsWithVersions;
    List<Double> screenDiagonalsInInches;
    List<ScreenResolutionDto> screenResolutions;
    List<ScreenTechnology> screenTechnologies;
    List<Integer> screenRefreshRates;
    List<Integer> ramVariants;
    List<Integer> romVariants;
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
    Boolean hasAudioProcessor;
    List<Float> frontCameraVariants;
    Boolean hasAudioOutput;
    List<ConnectionSocket> connectionSocketVariants;
    List<Integer> lengthVariants;
    List<Integer> widthVariants;
    List<Integer> thicknessVariants;
    List<Integer> weightVariants;
}
