package com.cafebabe.controller.phone;

import com.cafebabe.entity.phone.PhoneCpu;
import com.cafebabe.service.interfaces.CpuCoresBlockService;
import com.cafebabe.service.interfaces.PhoneCpuService;
import com.cafebabe.service.interfaces.PhoneGpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneCpuController {

    @Autowired
    protected PhoneCpuService phoneCpuService;

    @Autowired
    protected PhoneGpuService phoneGpuService;

    @Autowired
    protected CpuCoresBlockService cpuCoresBlockService;

    @PostMapping("api/phone-cpus")
    public void save(@RequestBody PhoneCpu cpu) {
        phoneCpuService.save(cpu);
    }

    @GetMapping("api/phone-cpus")
    public List<PhoneCpu> getAll() {
        return phoneCpuService.findAll();
    }
}
