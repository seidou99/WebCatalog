package com.cafebabe.controller.mobilephone;

import com.cafebabe.model.mobilephone.PhoneCpu;
import com.cafebabe.model.Gpu;
import com.cafebabe.service.interfaces.CpuCoresBlockService;
import com.cafebabe.service.interfaces.CpuService;
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
    protected CpuService cpuService;

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
        cpuService.save(cpu);
    }

    @GetMapping("api/cpus")
    public List<PhoneCpu> getAll() {
        return cpuService.findAll();
    }
}
