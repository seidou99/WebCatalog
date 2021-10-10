package com.cafebabe.generator;

import com.cafebabe.entity.*;
import com.cafebabe.entity.phone.CpuCoresBlock;
import com.cafebabe.entity.phone.Phone;
import com.cafebabe.entity.phone.PhoneCpu;
import com.cafebabe.entity.phone.PhoneGpu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface GeneratorConstants {

    public static final String GENERATOR_IMAGES_DIRECTORY = "generator_images";

    //    interface PhoneModels {
//, SAMSUNG_GALAXY_S20_FE = new PhoneModel(
//                "Samsung Galaxy S20 FE",
//                Manufacturers.SAMSUNG,
//                2020,
//                OperationSystems.ANDROID_TEN_DOT_ZERO,
//                6.5f,
//                Arrays.asList(new RamAndRomVariant(6, 128), new RamAndRomVariant(8, 256)),
//                1080,
//                2400,
//                ScreenTechnologies.AMOLED,
//                120,
//                FingerprintScannerLocations.ON_THE_SIDE_END,
//                2,
//                SimCardTypes.NANO_SIM,
//                true,
//                3,
//                12,
//                false,
//                PhoneCpus.QUALCOMM_SNAPDRAGON_865,
//                32,
//                true,
//                ConnectionSockets.USB_TYPE_C,
//                Arrays.asList(Colors.WHITE, Colors.RED, Colors.MINT, Colors.BLUE),
//                DustAndMoistureProtectionTypes.IP68,
//                159.8f,
//                74.5f,
//                8.4f,
//                190,
//                4500,
//                ScreenProtections.GORILLA_GLASS_V3,
//                true
//        ), XIAOMI_REDMI_NOTE_10 = new PhoneModel(
//                "Xiaomi Redmi Note 10",
//                Manufacturers.XIAOMI,
//                2021,
//                OperationSystems.ANDROID_ELEVEN,
//                6.43f,
//                Arrays.asList(new RamAndRomVariant(6, 128), new RamAndRomVariant(4, 64)),
//                1080,
//                2400,
//                ScreenTechnologies.AMOLED,
//                60,
//                FingerprintScannerLocations.ON_THE_SIDE_END,
//                2,
//                SimCardTypes.NANO_SIM,
//                true,
//                4,
//                48,
//                false,
//                PhoneCpus.QUALCOMM_SNAPDRAGON_678,
//                13,
//                true,
//                ConnectionSockets.USB_TYPE_C,
//                Arrays.asList(Colors.WHITE, Colors.GREEN, Colors.GREY),
//                DustAndMoistureProtectionTypes.IP53,
//                160.46f,
//                74.5f,
//                8.29f,
//                178.8f,
//                5000,
//                ScreenProtections.GORILLA_GLASS_V3,
//                false
//        );
//
//        List<PhoneModel> ALL = Arrays.asList(XIAOMI_REDMI_9_GLOBAL_WITH_NFC, XIAOMI_REDMI_9C_GLOBAL, XIAOMI_REDMI_NOTE_9T, POCO_X3_PRO_GLOBAL, SAMSUNG_GALAXY_S20_FE, XIAOMI_REDMI_NOTE_10);
//
//        Map<PhoneModel, String> PHONE_MODEL_TO_IMAGES_DIRECTORY_MAP = new HashMap<PhoneModel, String>() {{
//            put(XIAOMI_REDMI_9_GLOBAL_WITH_NFC, "redmi_9");
//            put(XIAOMI_REDMI_9C_GLOBAL, "redmi_9c");
//            put(XIAOMI_REDMI_NOTE_9T, "redmi_note_9t");
//            put(POCO_X3_PRO_GLOBAL, "poco_x3_pro");
//            put(XIAOMI_REDMI_NOTE_10, "redmi_note_10");
//            put(SAMSUNG_GALAXY_S20_FE, "samsung_galaxy_s20_fe");
//        }};
//    }
//

//    interface Shops {
//        Shop XISTORE = new Shop("Xistore"), TECHNO_WORLD = new Shop("ТехноМир");
//
//        List<Shop> ALL = Arrays.asList(XISTORE, TECHNO_WORLD);
//    }

}
