package com.cafebabe.controller;

import com.cafebabe.entity.ShopItem;
import com.cafebabe.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    protected SearchServiceImpl searchService;

    @GetMapping("/api/shop_items")
    @Transactional
    public List<ShopItem> findShopItems(@RequestParam String name) {
        return searchService.findByName(name);
    }
}
