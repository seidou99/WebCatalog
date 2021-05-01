package com.cafebabe.controller.mobilephone;

import com.cafebabe.entity.mobilephone.PhoneCpu;
import com.cafebabe.entity.Gpu;
import com.cafebabe.service.interfaces.CpuCoresBlockService;
import com.cafebabe.service.interfaces.PhoneCpuService;
import com.cafebabe.service.interfaces.GpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CpuController {

    @Autowired
    protected PhoneCpuService phoneCpuService;

    @Autowired
    protected GpuService gpuService;

    @Autowired
    protected CpuCoresBlockService cpuCoresBlockService;

    @PostMapping("api/cpus")
    public void save(@RequestBody PhoneCpu cpu) {
        Gpu integratedGpu = cpu.getIntegratedGpu();
        if (integratedGpu != null) {
            gpuService.save(integratedGpu);
        }
        cpuCoresBlockService.save(cpu.getCoresBlocks());
        phoneCpuService.save(cpu);
    }

    @GetMapping("api/cpus")
    public List<PhoneCpu> getAll() {
        return phoneCpuService.findAll();
    }
}
