package com.cafebabe.service.impl;

import com.cafebabe.entity.PhoneGpu;
import com.cafebabe.repository.PhoneGpuRepository;
import com.cafebabe.service.interfaces.PhoneGpuService;
import org.springframework.stereotype.Service;

@Service
public class PhoneGpuServiceImpl extends BaseDataObjectWithUniqueNameServiceImpl<PhoneGpuRepository, PhoneGpu> implements PhoneGpuService {
}
