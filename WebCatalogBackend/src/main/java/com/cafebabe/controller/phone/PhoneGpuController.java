package com.cafebabe.controller.phone;

import com.cafebabe.entity.phone.PhoneGpu;
import com.cafebabe.service.interfaces.PhoneGpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneGpuController {

    @Autowired
    protected PhoneGpuService phoneGpuService;

    @PostMapping("api/phone-integrated-gpus")
    public void save(@RequestBody PhoneGpu phoneGpu) {
        phoneGpuService.save(phoneGpu);
    }

    @GetMapping("api/phone-integrated-gpus")
    public List<PhoneGpu> findAll() {
        return phoneGpuService.findAll();
    }
}
