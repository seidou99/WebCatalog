package com.cafebabe.service.interfaces;

import com.cafebabe.entity.Gpu;

import java.util.List;

public interface GpuService extends BaseDataObjectService<Gpu> {

    List<Gpu> getAllMobileGpus();
}
