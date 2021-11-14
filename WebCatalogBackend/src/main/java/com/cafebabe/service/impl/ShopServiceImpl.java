package com.cafebabe.service.impl;

import com.cafebabe.entity.Shop;
import com.cafebabe.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl {

    @Autowired
    protected ShopRepository shopRepository;

    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    public Optional<Shop> findById(BigInteger id) {
        return shopRepository.findById(id);
    }

    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    public void deleteById(BigInteger id) {
        shopRepository.deleteById(id);
    }
}
