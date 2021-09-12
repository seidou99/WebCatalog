package com.cafebabe.service.impl;

import com.cafebabe.entity.Manufacturer;
import com.cafebabe.entity.ManufacturerType;
import com.cafebabe.repository.ManufacturerTypeRepository;
import com.cafebabe.repository.MobilePhoneManufacturerRepository;
import com.cafebabe.service.interfaces.ManufacturerService;
import com.cafebabe.service.interfaces.ManufacturerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImpl extends BaseDataObjectWithUniqueNameServiceImpl<MobilePhoneManufacturerRepository, Manufacturer> implements ManufacturerService {

    @Autowired
    protected ManufacturerTypeService manufacturerTypeService;

    @Autowired
    protected ManufacturerTypeRepository manufacturerTypeRepository;

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        List<String> manufacturerTypesNames = manufacturer.getManufacturerTypes().stream().map(ManufacturerType::getName).collect(Collectors.toList());
        List<ManufacturerType> manufacturerTypes = manufacturerTypeRepository.findAllByNameIn(manufacturerTypesNames);
        manufacturer.setManufacturerTypes(manufacturerTypes);
        return baseRepository.save(manufacturer);
    }
}
