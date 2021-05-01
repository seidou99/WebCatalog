package com.cafebabe.repository;

import com.cafebabe.entity.Gpu;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GpuRepository extends BaseDataObjectRepository<Gpu>{

    @Query("select gpu from Gpu gpu where gpu.gpuType = 'MOBILE' and gpu.isIntegrated = true")
    public List<Gpu> getAllMobileIntegratedGpus();
}
