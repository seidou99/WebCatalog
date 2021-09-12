package com.cafebabe.service.impl;

import com.cafebabe.entity.DustAndMoistureProtection;
import com.cafebabe.repository.DustAndMoistureProtectionRepository;
import com.cafebabe.service.interfaces.DustAndMoistureProtectionService;
import org.springframework.stereotype.Service;

@Service
public class DustAndMoistureProtectionServiceImpl extends BaseDataObjectWithUniqueNameServiceImpl<DustAndMoistureProtectionRepository, DustAndMoistureProtection> implements DustAndMoistureProtectionService {
}
