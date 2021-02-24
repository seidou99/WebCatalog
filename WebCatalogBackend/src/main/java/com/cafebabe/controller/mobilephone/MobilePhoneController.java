package com.cafebabe.controller.mobilephone;

import com.cafebabe.model.mobilephone.MobilePhoneModel;
import com.cafebabe.service.MobilePhoneModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MobilePhoneController {

    @Autowired
    protected MobilePhoneModelService mobilePhoneModelService;

    @GetMapping("/phones")
    public List<MobilePhoneModel> getAllPhoneModels(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize) {
        return mobilePhoneModelService.findAll();
    }
}
