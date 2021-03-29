package com.cafebabe.controller.mobilephone;

import com.cafebabe.model.BodyColor;
import com.cafebabe.service.interfaces.BodyColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BodyColorController {

    @Autowired
    protected BodyColorService bodyColorService;

    @PostMapping("api/body-colors")
    public void save(@RequestBody BodyColor bodyColor) {
        bodyColorService.save(bodyColor);
    }

    @GetMapping("api/body-colors")
    public List<BodyColor> getAll() {
        return bodyColorService.findAll();
    }
}
