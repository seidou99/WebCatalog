package com.cafebabe.controller.phone_model;

import com.cafebabe.entity.mobilephone.OperationSystem;
import com.cafebabe.service.mobilephone.interfaces.OperationSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationSystemController {

    @Autowired
    protected OperationSystemService operationSystemService;

    @PostMapping("api/operation-systems")
    public void save(@RequestBody OperationSystem operationSystem) {
        operationSystemService.save(operationSystem);
    }

    @GetMapping("api/operation-systems")
    public List<OperationSystem> getAll() {
        return operationSystemService.findAll();
    }
}
