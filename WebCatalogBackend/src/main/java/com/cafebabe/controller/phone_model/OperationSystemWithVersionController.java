package com.cafebabe.controller.phone_model;

import com.cafebabe.entity.mobilephone.OperationSystemWithVersion;
import com.cafebabe.service.mobilephone.interfaces.OperationSystemWithVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationSystemWithVersionController {

    @Autowired
    protected OperationSystemWithVersionService operationSystemWithVersionService;

    @PostMapping("api/operation-systems-with-versions")
    public void save(@RequestBody OperationSystemWithVersion operationSystemWithVersion) {
        operationSystemWithVersionService.save(operationSystemWithVersion);
    }

    @GetMapping("api/operation-systems-with-versions")
    public List<OperationSystemWithVersion> getAll() {
        return operationSystemWithVersionService.findAll();
    }
}
