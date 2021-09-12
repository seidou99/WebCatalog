package com.cafebabe.service.impl;

import com.cafebabe.entity.ManufacturerType;
import com.cafebabe.repository.ManufacturerTypeRepository;
import com.cafebabe.service.interfaces.ManufacturerTypeService;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerTypeServiceImpl extends BaseDataObjectWithUniqueNameServiceImpl<ManufacturerTypeRepository, ManufacturerType> implements ManufacturerTypeService {
}
