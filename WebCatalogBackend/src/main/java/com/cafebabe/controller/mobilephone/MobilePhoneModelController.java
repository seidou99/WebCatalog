package com.cafebabe.controller.mobilephone;

import com.cafebabe.model.mobilephone.MobilePhoneModel;
import com.cafebabe.service.interfaces.RamAndRomVariantService;
import com.cafebabe.service.mobilephone.interfaces.MobilePhoneModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MobilePhoneModelController {

    @Autowired
    protected MobilePhoneModelService mobilePhoneModelService;

    @Autowired
    protected RamAndRomVariantService ramAndRomVariantService;

    @GetMapping("api/phones/models")
    public List<MobilePhoneModel> getAll() {
        return mobilePhoneModelService.findAll();
    }

    @PostMapping("api/phones/models")
    public void save(@RequestBody MobilePhoneModel mobilePhoneModel) {
        ramAndRomVariantService.save(mobilePhoneModel.getRamAndRomVariants());
        this.mobilePhoneModelService.save(mobilePhoneModel);
    }
}
