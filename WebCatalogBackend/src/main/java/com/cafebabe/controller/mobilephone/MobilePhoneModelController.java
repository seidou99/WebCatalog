package com.cafebabe.controller.mobilephone;

import com.cafebabe.model.mobilephone.MobilePhoneModel;
import com.cafebabe.service.mobilephone.interfaces.MobilePhoneModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MobilePhoneModelController {

    @Autowired
    protected MobilePhoneModelService mobilePhoneModelService;

    @GetMapping("/phones/models")
    public List<MobilePhoneModel> getAll() {
        return mobilePhoneModelService.findAll();
    }
}
