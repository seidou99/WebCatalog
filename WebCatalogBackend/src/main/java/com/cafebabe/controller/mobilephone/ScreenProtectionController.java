package com.cafebabe.controller.mobilephone;

import com.cafebabe.model.ScreenProtection;
import com.cafebabe.service.interfaces.ScreenProtectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScreenProtectionController {

    @Autowired
    protected ScreenProtectionService screenProtectionService;

    @PostMapping("api/screen-protections")
    public void save(@RequestBody ScreenProtection screenProtection) {
        screenProtectionService.save(screenProtection);
    }

    @GetMapping("api/screen-protections")
    public List<ScreenProtection> getAll() {
        return screenProtectionService.findAll();
    }
}
