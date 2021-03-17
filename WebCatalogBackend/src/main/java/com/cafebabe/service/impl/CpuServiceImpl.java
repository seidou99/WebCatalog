package com.cafebabe.service.impl;

import com.cafebabe.model.Cpu;
import com.cafebabe.repository.CpuRepository;
import com.cafebabe.service.interfaces.CpuService;
import org.springframework.stereotype.Service;

@Service
public class CpuServiceImpl extends BaseDataObjectServiceImpl<CpuRepository, Cpu> implements CpuService {
}
