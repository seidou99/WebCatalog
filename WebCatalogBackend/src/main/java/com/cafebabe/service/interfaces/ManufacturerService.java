package com.cafebabe.service.interfaces;

import com.cafebabe.entity.Manufacturer;
import com.cafebabe.entity.ManufacturerType;

import java.util.List;

public interface ManufacturerService extends BaseDataObjectWithUniqueNameService<Manufacturer> {

    default List<Manufacturer> findAllMobilePhoneManufacturers() {
        return findAllManufacturersWithType(ManufacturerType.MOBILE_PHONE);
    };

    List<Manufacturer> findAllManufacturersWithType(String type);
}
