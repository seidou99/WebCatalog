package com.cafebabe;

import com.cafebabe.entity.phone.CpuCoresBlock;
import com.cafebabe.entity.phone.PhoneCpu;

import java.util.Arrays;
import java.util.List;

public interface PhoneCpus {
    PhoneCpu MEDIATEK_HELIO_G35 = new PhoneCpu("Mediatek Helio G35", PhoneGpus.POWER_VR_GE_8320, Arrays.asList(new CpuCoresBlock("ARM Cortex-A53", 4, 2300), new CpuCoresBlock("ARM Cortex-A53", 4, 1800)), 64, 12),
            MEDIATEK_HELIO_G80 = new PhoneCpu("Mediatek Helio G80", PhoneGpus.MALI_G52_MC2, Arrays.asList(new CpuCoresBlock("ARM Cortex-A75", 2, 2000), new CpuCoresBlock("ARM Cortex-A55", 6, 1800)), 64, 12),
            MEDIATEK_DIMENSITY_800 = new PhoneCpu("Mediatek Dimensity 800", PhoneGpus.MALI_G57_MC3, Arrays.asList(new CpuCoresBlock("ARM Cortex-A76", 2, 2400), new CpuCoresBlock("ARM Cortex-A55", 6, 2000)), 64, 7),
            QUALCOMM_SNAPDRAGON_678 = new PhoneCpu("Qualcomm Snapdragon 678", PhoneGpus.ADRENO_612, Arrays.asList(new CpuCoresBlock("Kryo 460 Gold", 2, 2200), new CpuCoresBlock("Kryo 460 Silver", 6, 1700)), 64, 11),
            QUALCOMM_SNAPDRAGON_860 = new PhoneCpu("Qualcomm Snapdragon 860", PhoneGpus.ADRENO_640, Arrays.asList(new CpuCoresBlock("Kryo 485", 1, 2960), new CpuCoresBlock("Kryo 485", 3, 2420), new CpuCoresBlock("Kryo 485", 4, 1780)), 64, 7),
            QUALCOMM_SNAPDRAGON_865 = new PhoneCpu("Qualcomm Snapdragon 865", PhoneGpus.ADRENO_650, Arrays.asList(new CpuCoresBlock("Kryo 585", 1, 2840), new CpuCoresBlock("Kryo 585", 3, 2420), new CpuCoresBlock("Kryo 585", 4, 1800)), 64, 7);

    List<PhoneCpu> ALL = Arrays.asList(MEDIATEK_HELIO_G35, MEDIATEK_HELIO_G80, MEDIATEK_DIMENSITY_800, QUALCOMM_SNAPDRAGON_678, QUALCOMM_SNAPDRAGON_860, QUALCOMM_SNAPDRAGON_865);
}
