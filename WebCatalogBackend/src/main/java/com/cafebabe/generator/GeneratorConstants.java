package com.cafebabe.generator;

import com.cafebabe.entity.*;

import java.util.*;

public interface GeneratorConstants {

    public static final String GENERATOR_IMAGES_DIRECTORY = "generator_images";

    interface ManufacturerTypes {
        ManufacturerType MOBILE_PHONE = new ManufacturerType("MOBILE_PHONE");

        List<ManufacturerType> ALL = Collections.singletonList(MOBILE_PHONE);
    }

    interface Manufacturers {
        Manufacturer XIAOMI = new Manufacturer("Xiaomi", ManufacturerTypes.MOBILE_PHONE), SAMSUNG = new Manufacturer("Samsung", ManufacturerTypes.MOBILE_PHONE), ONEPLUS = new Manufacturer("OnePlus", ManufacturerTypes.MOBILE_PHONE);

        List<Manufacturer> ALL = Arrays.asList(XIAOMI, SAMSUNG, ONEPLUS);
    }

    interface OperationSystems {
        OperationSystem ANDROID = new OperationSystem("Android", OperationSystemType.MOBILE);
        List<OperationSystem> ALL_OPERATION_SYSTEMS = Arrays.asList(ANDROID);

        OperationSystemWithVersion ANDROID_ELEVEN = new OperationSystemWithVersion("11", ANDROID), ANDROID_TEN_DOT_ZERO = new OperationSystemWithVersion("10.0", ANDROID), ANDROID_NINE_DOT_ZERO_PIE = new OperationSystemWithVersion("9.0 Pie", ANDROID);
        List<OperationSystemWithVersion> ALL_OPERATION_SYSTEMS_WITH_VERSIONS = Arrays.asList(ANDROID_ELEVEN, ANDROID_TEN_DOT_ZERO, ANDROID_NINE_DOT_ZERO_PIE);
    }

    interface ScreenTechnologies {
        ScreenTechnology IPS = new ScreenTechnology("IPS"), AMOLED = new ScreenTechnology("AMOLED"), OLED = new ScreenTechnology("OLED"), PVA_SLCD = new ScreenTechnology("PVA (SLCD)"), PLS = new ScreenTechnology("PLS");

        List<ScreenTechnology> ALL = Arrays.asList(IPS, AMOLED, OLED, PVA_SLCD, PLS);
    }

    interface Colors {
        Color BLACK = new Color("Черный"), WHITE = new Color("Белый"), SILVER = new Color("Серебристый"), BIEGE = new Color("Бежевый"), TURQUOISE = new Color("Бирюзовый"), BURGUNDY = new Color("Бордовый"), BRONZE = new Color("Бронзовый"), SKY_BLUE = new Color("Голубой"), YELLOW = new Color("Желтый"), GREEN = new Color("Зеленый"), GOLDEN = new Color("золотистый"), CORAL = new Color("Коралловый"), BROWNISH = new Color("Коричневатый"), RED = new Color("Красный"), COPPER = new Color("Медный"), MINT = new Color("Мятный"), ORANGE = new Color("Оранжевый"), SANDY = new Color("Песочный"), PINK = new Color("Розовый"), LIGHT_BLUE = new Color("Светло-синий"), GREY = new Color("Серый"), BLUE = new Color("Синий"), LILAC = new Color("Сиреневый"), DARK_GREEN = new Color("Темно-зеленый"), DARK_BROWN = new Color("Темно-коричневый"), DARK_RED = new Color("Темно-красный"), DARK_GREY = new Color("Темно-серый"), DARK_BLUE = new Color("Темно-синий"), PURPLE = new Color("Фиолетовый");

        List<Color> ALL = Arrays.asList(BLACK, WHITE, SILVER, BIEGE, TURQUOISE, BURGUNDY, BRONZE, SKY_BLUE, YELLOW, GREEN, GOLDEN, CORAL, BROWNISH, RED, COPPER, MINT, ORANGE, SANDY, PINK, LIGHT_BLUE, GREY, BLUE, LILAC, DARK_GREEN, DARK_BROWN, DARK_RED, DARK_GREY, DARK_BLUE, PURPLE);
    }

    interface FingerprintScannerLocations {
        FingerprintScannerLocation ON_THE_FRONT_PANEL = new FingerprintScannerLocation("На фронтальной панели"), ON_THE_BACK_PANEL = new FingerprintScannerLocation("На тыльной панели"), ON_THE_SIDE_END = new FingerprintScannerLocation("На боковом торце"), BUILT_INTO_THE_DISPLAY = new FingerprintScannerLocation("Встроен в дисплей");

        List<FingerprintScannerLocation> ALL = Arrays.asList(ON_THE_FRONT_PANEL, ON_THE_BACK_PANEL, ON_THE_SIDE_END, BUILT_INTO_THE_DISPLAY);
    }

    interface ScreenProtections {

        ScreenProtection GORILLA_GLASS_V1 = new ScreenProtection("Gorilla Glass v1"), GORILLA_GLASS_V2 = new ScreenProtection("Gorilla Glass v2"), GORILLA_GLASS_V3 = new ScreenProtection("Gorilla Glass v3"), GORILLA_GLASS_V3_PLUS = new ScreenProtection("Gorilla Glass v3+"), GORILLA_GLASS_V4 = new ScreenProtection("Gorilla Glass v4"), GORILLA_GLASS_V5 = new ScreenProtection("Gorilla Glass v5"), GORILLA_GLASS_V6 = new ScreenProtection("Gorilla Glass v6"), GORILLA_GLASS_VICTUS = new ScreenProtection("Gorilla Glass Victus"), JAPAN_AGC_GLASS = new ScreenProtection("Japan AGC glass"), DRAGONTRAIL = new ScreenProtection("Dragontrail"), DINOREX_GLASS = new ScreenProtection("Dinorex Glass"), PANDA_KING_GLASS = new ScreenProtection("Panda King Glass"), XENSATION_GLASS = new ScreenProtection("Xensation Glass"), CERAMIC_SHIELD = new ScreenProtection("Ceramic Shield");

        List<ScreenProtection> ALL = Arrays.asList(GORILLA_GLASS_V1, GORILLA_GLASS_V2, GORILLA_GLASS_V3, GORILLA_GLASS_V3_PLUS, GORILLA_GLASS_V4, GORILLA_GLASS_V5, GORILLA_GLASS_V6, GORILLA_GLASS_VICTUS, JAPAN_AGC_GLASS, DRAGONTRAIL, DINOREX_GLASS, PANDA_KING_GLASS, XENSATION_GLASS, CERAMIC_SHIELD);
    }

    interface PhoneGpus {

        PhoneGpu POWER_VR_GE_8320 = new PhoneGpu("PowerVR GE8320", 650),
                MALI_G52_MC2 = new PhoneGpu("Mali-G52 MC2", 950),
                MALI_G57_MC3 = new PhoneGpu("Mali-G57 MC3"),
                ADRENO_612 = new PhoneGpu("Adreno 612"),
                ADRENO_650 = new PhoneGpu("Adreno 650"),
                ADRENO_640 = new PhoneGpu("Adreno 640");

        List<PhoneGpu> ALL = Arrays.asList(POWER_VR_GE_8320, MALI_G52_MC2, MALI_G57_MC3, ADRENO_650, ADRENO_640, ADRENO_612);
    }

    interface PhoneCpus {
        PhoneCpu MEDIATEK_HELIO_G35 = new PhoneCpu("Mediatek Helio G35", PhoneGpus.POWER_VR_GE_8320, Arrays.asList(new CpuCoresBlock("ARM Cortex-A53", 4, 2300), new CpuCoresBlock("ARM Cortex-A53", 4, 1800)), 64, 12),
                MEDIATEK_HELIO_G80 = new PhoneCpu("Mediatek Helio G80", PhoneGpus.MALI_G52_MC2, Arrays.asList(new CpuCoresBlock("ARM Cortex-A75", 2, 2000), new CpuCoresBlock("ARM Cortex-A55", 6, 1800)), 64, 12),
                MEDIATEK_DIMENSITY_800 = new PhoneCpu("Mediatek Dimensity 800", PhoneGpus.MALI_G57_MC3, Arrays.asList(new CpuCoresBlock("ARM Cortex-A76", 2, 2400), new CpuCoresBlock("ARM Cortex-A55", 6, 2000)), 64, 7),
                QUALCOMM_SNAPDRAGON_678 = new PhoneCpu("Qualcomm Snapdragon 678", PhoneGpus.ADRENO_612, Arrays.asList(new CpuCoresBlock("Kryo 460 Gold", 2, 2200), new CpuCoresBlock("Kryo 460 Silver", 6, 1700)), 64, 11),
                QUALCOMM_SNAPDRAGON_860 = new PhoneCpu("Qualcomm Snapdragon 860", PhoneGpus.ADRENO_640, Arrays.asList(new CpuCoresBlock("Kryo 485", 1, 2960), new CpuCoresBlock("Kryo 485", 3, 2420), new CpuCoresBlock("Kryo 485", 4, 1780)), 64, 7),
                QUALCOMM_SNAPDRAGON_865 = new PhoneCpu("Qualcomm Snapdragon 865", PhoneGpus.ADRENO_650, Arrays.asList(new CpuCoresBlock("Kryo 585", 1, 2840), new CpuCoresBlock("Kryo 585", 3, 2420), new CpuCoresBlock("Kryo 585", 4, 1800)), 64, 7);

        List<PhoneCpu> ALL = Arrays.asList(MEDIATEK_HELIO_G35, MEDIATEK_HELIO_G80, MEDIATEK_DIMENSITY_800, QUALCOMM_SNAPDRAGON_678, QUALCOMM_SNAPDRAGON_860, QUALCOMM_SNAPDRAGON_865);
    }

    interface SimCardTypes {
        SimCardType MICRO_SIM = new SimCardType("micro-SIM"), NANO_SIM = new SimCardType("nano-SIM"), E_SIM = new SimCardType("eSIM");

        List<SimCardType> ALL = Arrays.asList(MICRO_SIM, NANO_SIM, E_SIM);
    }

    interface DustAndMoistureProtectionTypes {
        DustAndMoistureProtection IPX2 = new DustAndMoistureProtection("IPX2"), IPX4 = new DustAndMoistureProtection("IPX4"), IP52 = new DustAndMoistureProtection("IP52"), IP53 = new DustAndMoistureProtection("IP53"), IP54 = new DustAndMoistureProtection("IP54"), IP64 = new DustAndMoistureProtection("IP64"), IP65 = new DustAndMoistureProtection("IP65"), IP67 = new DustAndMoistureProtection("IP67"), IPX8 = new DustAndMoistureProtection("IPX8"), IP68 = new DustAndMoistureProtection("IP68"), IP69K = new DustAndMoistureProtection("IP69K");

        List<DustAndMoistureProtection> ALL = Arrays.asList(IPX2, IPX4, IP52, IP53, IP54, IP64, IP65, IP67, IPX8, IP68, IP69K);
    }

    interface ConnectionSockets {
        ConnectionSocket LIGHTNING = new ConnectionSocket("lightning"), MICRO_USB = new ConnectionSocket("microUSB"), USB_TYPE_C = new ConnectionSocket("USB Type-C");

        List<ConnectionSocket> ALL = Arrays.asList(LIGHTNING, MICRO_USB, USB_TYPE_C);
    }

//    interface PhoneModels {
//        PhoneModel XIAOMI_REDMI_9_GLOBAL_WITH_NFC = new PhoneModel(
//                "Xiaomi Redmi 9 международная версия с NFC",
//                Manufacturers.XIAOMI,
//                2020,
//                OperationSystems.ANDROID_TEN_DOT_ZERO,
//                6.53f,
//                Arrays.asList(new RamAndRomVariant(3, 32), new RamAndRomVariant(4, 64)),
//                1080,
//                2340,
//                ScreenTechnologies.IPS,
//                60,
//                FingerprintScannerLocations.ON_THE_BACK_PANEL,
//                2,
//                SimCardTypes.NANO_SIM,
//                true,
//                4,
//                13,
//                false,
//                PhoneCpus.MEDIATEK_HELIO_G80,
//                8,
//                true,
//                ConnectionSockets.USB_TYPE_C,
//                Arrays.asList(Colors.GREEN, Colors.GREY, Colors.PURPLE),
//                null,
//                163.3f,
//                77f,
//                9.1f,
//                198f,
//                5020,
//                ScreenProtections.GORILLA_GLASS_V3,
//                true
//        ), XIAOMI_REDMI_9C_GLOBAL = new PhoneModel(
//                "Xiaomi Redmi 9C международная версия",
//                Manufacturers.XIAOMI,
//                2020,
//                OperationSystems.ANDROID_TEN_DOT_ZERO,
//                6.53f,
//                Arrays.asList(new RamAndRomVariant(2, 32), new RamAndRomVariant(3, 64), new RamAndRomVariant(4, 64)),
//                720,
//                1600,
//                ScreenTechnologies.IPS,
//                60,
//                FingerprintScannerLocations.ON_THE_BACK_PANEL,
//                2,
//                SimCardTypes.NANO_SIM,
//                true,
//                3,
//                13,
//                false,
//                PhoneCpus.MEDIATEK_HELIO_G35,
//                5,
//                true,
//                ConnectionSockets.MICRO_USB,
//                Arrays.asList(Colors.ORANGE, Colors.GREY, Colors.BLUE),
//                null,
//                164.9f,
//                77.07f,
//                9f,
//                196f,
//                5000,
//                null,
//                false
//        ), XIAOMI_REDMI_NOTE_9T = new PhoneModel(
//                "Xiaomi Redmi Note 9T международная версия",
//                Manufacturers.XIAOMI,
//                2021,
//                OperationSystems.ANDROID_TEN_DOT_ZERO,
//                6.53f,
//                Arrays.asList(new RamAndRomVariant(4, 64), new RamAndRomVariant(4, 128)),
//                1080,
//                2340,
//                ScreenTechnologies.IPS,
//                60,
//                FingerprintScannerLocations.ON_THE_SIDE_END,
//                2,
//                SimCardTypes.NANO_SIM,
//                true,
//                3,
//                48,
//                true,
//                PhoneCpus.MEDIATEK_DIMENSITY_800,
//                13,
//                true,
//                ConnectionSockets.USB_TYPE_C,
//                Arrays.asList(Colors.BLACK, Colors.PURPLE),
//                null,
//                161.9f,
//                77.3f,
//                9.05f,
//                199f,
//                5000,
//                ScreenProtections.GORILLA_GLASS_V5,
//                true
//        ), POCO_X3_PRO_GLOBAL = new PhoneModel(
//                "POCO X3 Pro международная версия",
//                Manufacturers.XIAOMI,
//                2021,
//                OperationSystems.ANDROID_ELEVEN,
//                6.67f,
//                Arrays.asList(new RamAndRomVariant(6, 128), new RamAndRomVariant(8, 256)),
//                1080,
//                2400,
//                ScreenTechnologies.IPS,
//                120,
//                FingerprintScannerLocations.ON_THE_SIDE_END,
//                2,
//                SimCardTypes.NANO_SIM,
//                true,
//                4,
//                48,
//                false,
//                PhoneCpus.QUALCOMM_SNAPDRAGON_860,
//                20,
//                true,
//                ConnectionSockets.USB_TYPE_C,
//                Arrays.asList(Colors.BLACK, Colors.BRONZE, Colors.BLUE),
//                DustAndMoistureProtectionTypes.IP53,
//                165.3f,
//                76.8f,
//                9.4f,
//                215f,
//                5160,
//                ScreenProtections.GORILLA_GLASS_V6,
//                true
//        ), SAMSUNG_GALAXY_S20_FE = new PhoneModel(
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
//    interface Phones {
//        Phone XIAOMI_REDMI_9_3GB_32GB_GLOBAL_WITH_NFC_GREEN = new Phone("Xiaomi Redmi 9 3GB/32GB международная версия с NFC (зеленый)", PhoneModels.XIAOMI_REDMI_9_GLOBAL_WITH_NFC, Colors.GREEN, new RamAndRomVariant(3, 32)), XIAOMI_REDMI_9_4GB_64GB_GLOBAL_WITH_NFC_PURPLE = new Phone("Xiaomi Redmi 9 4GB/64GB международная версия с NFC (фиолетовый)", PhoneModels.XIAOMI_REDMI_9_GLOBAL_WITH_NFC, Colors.PURPLE, new RamAndRomVariant(4, 64));
//
//        List<Phone> ALL = Arrays.asList(XIAOMI_REDMI_9_3GB_32GB_GLOBAL_WITH_NFC_GREEN, XIAOMI_REDMI_9_4GB_64GB_GLOBAL_WITH_NFC_PURPLE);
//    }
//
//    interface Shops {
//        Shop XISTORE = new Shop("Xistore"), TECHNO_WORLD = new Shop("ТехноМир");
//
//        List<Shop> ALL = Arrays.asList(XISTORE, TECHNO_WORLD);
//    }
//
//    interface ItemPricesInShops {
//
//    }

}
