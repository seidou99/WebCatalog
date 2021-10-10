package com.cafebabe;

import com.cafebabe.entity.Manufacturer;
import com.cafebabe.entity.ManufacturerType;
import com.cafebabe.generator.GeneratorConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface Manufacturers {

    interface ManufacturerTypes {
        ManufacturerType MOBILE_PHONE = new ManufacturerType("MOBILE_PHONE");

        List<ManufacturerType> ALL = Collections.singletonList(MOBILE_PHONE);
    }

    Manufacturer XIAOMI = new Manufacturer("Xiaomi", ManufacturerTypes.MOBILE_PHONE), SAMSUNG = new Manufacturer("Samsung", ManufacturerTypes.MOBILE_PHONE), ONEPLUS = new Manufacturer("OnePlus", ManufacturerTypes.MOBILE_PHONE);

    List<Manufacturer> ALL = Arrays.asList(XIAOMI, SAMSUNG, ONEPLUS);
}
