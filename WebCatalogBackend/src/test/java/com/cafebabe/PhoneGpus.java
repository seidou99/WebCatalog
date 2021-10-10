package com.cafebabe;

import com.cafebabe.entity.phone.PhoneGpu;

import java.util.Arrays;
import java.util.List;

public interface PhoneGpus {

    PhoneGpu POWER_VR_GE_8320 = new PhoneGpu("PowerVR GE8320", 650),
            MALI_G52_MC2 = new PhoneGpu("Mali-G52 MC2", 950),
            MALI_G57_MC3 = new PhoneGpu("Mali-G57 MC3"),
            ADRENO_612 = new PhoneGpu("Adreno 612"),
            ADRENO_650 = new PhoneGpu("Adreno 650"),
            ADRENO_640 = new PhoneGpu("Adreno 640");

    List<PhoneGpu> ALL = Arrays.asList(POWER_VR_GE_8320, MALI_G52_MC2, MALI_G57_MC3, ADRENO_650, ADRENO_640, ADRENO_612);
}
