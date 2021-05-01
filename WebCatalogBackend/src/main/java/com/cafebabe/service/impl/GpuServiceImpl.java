package com.cafebabe.service.impl;

import com.cafebabe.entity.Gpu;
import com.cafebabe.repository.GpuRepository;
import com.cafebabe.service.interfaces.GpuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpuServiceImpl extends BaseDataObjectServiceImpl<GpuRepository, Gpu> implements GpuService {

    @Override
    public List<Gpu> getAllMobileGpus() {
        return baseRepository.getAllMobileIntegratedGpus();
    }
}
