package com.cafebabe.controller;

import com.cafebabe.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColorController {

    @Autowired
    protected com.cafebabe.service.interfaces.ColorService ColorService;

    @PostMapping("api/colors")
    public void save(@RequestBody Color bodyColor) {
        ColorService.save(bodyColor);
    }

    @GetMapping("api/colors")
    public List<Color> getAll() {
        return ColorService.findAll();
    }
}
