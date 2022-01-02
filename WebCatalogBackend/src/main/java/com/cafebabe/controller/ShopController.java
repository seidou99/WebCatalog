package com.cafebabe.controller;

import com.cafebabe.entity.Shop;
import com.cafebabe.service.impl.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ShopController {

    @Autowired
    protected ShopServiceImpl shopService;

    @PostMapping("api/shops")
    public Shop create(@RequestBody Shop shop) {
        return shopService.save(shop);
    }

    @PutMapping("api/shops")
    public void edit(@RequestBody Shop shop) {
        shopService.save(shop);
    }

    @GetMapping("api/shops/{id}")
    public Shop findById(@PathVariable BigInteger id) {
        return shopService.findById(id).get();
    }

    @GetMapping("api/shops")
    public List<Shop> findAll() {
        return shopService.findAll();
    }

    @DeleteMapping("api/shops/{id}")
    public void delete(@PathVariable BigInteger id) {
        shopService.deleteById(id);
    }
}
