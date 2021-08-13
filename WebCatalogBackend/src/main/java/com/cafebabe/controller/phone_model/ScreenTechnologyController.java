package com.cafebabe.controller.phone_model;

import com.cafebabe.entity.ScreenTechnology;
import com.cafebabe.service.interfaces.ScreenTechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScreenTechnologyController {

    @Autowired
    protected ScreenTechnologyService screenTechnologyService;

    @PostMapping("api/screen-technologies")
    public void save(@RequestBody ScreenTechnology screenTechnology) {
        screenTechnologyService.save(screenTechnology);
    }

    @GetMapping("api/screen-technologies")
    public List<ScreenTechnology> getAll() {
        return screenTechnologyService.findAll();
    }
}
