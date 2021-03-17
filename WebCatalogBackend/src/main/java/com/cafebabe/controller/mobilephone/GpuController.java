package com.cafebabe.controller.mobilephone;

import com.cafebabe.model.Gpu;
import com.cafebabe.service.interfaces.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GpuController {

    @Autowired
    protected GpuService gpuService;

    @PostMapping("api/gpus")
    public void save(@RequestBody Gpu gpu) {
        gpuService.save(gpu);
    }

    @GetMapping("api/gpus")
    public List<Gpu> getAll() {
        return gpuService.findAll();
    }

    @GetMapping("api/mobile-integrated-gpus")
    public List<Gpu> getAllMobileGpus() {
        return gpuService.getAllMobileGpus();
    }
}
