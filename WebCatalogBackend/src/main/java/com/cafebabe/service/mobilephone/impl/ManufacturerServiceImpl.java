package com.cafebabe.service.mobilephone.impl;

import com.cafebabe.model.Manufacturer;
import com.cafebabe.repository.mobilephone.MobilePhoneManufacturerRepository;
import com.cafebabe.service.impl.BaseDataObjectServiceImpl;
import com.cafebabe.service.mobilephone.interfaces.ManufacturerService;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl extends BaseDataObjectServiceImpl<MobilePhoneManufacturerRepository, Manufacturer> implements ManufacturerService {
}
