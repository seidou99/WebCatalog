package com.cafebabe.service.impl;

import com.cafebabe.entity.PhoneGpu;
import com.cafebabe.repository.PhoneGpuRepository;
import com.cafebabe.service.interfaces.PhoneGpuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneGpuServiceImpl extends BaseDataObjectServiceImpl<PhoneGpuRepository, PhoneGpu> implements PhoneGpuService {
}
