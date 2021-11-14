package com.cafebabe.repository;

import com.cafebabe.entity.Shop;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface ShopRepository extends CrudRepository<Shop, BigInteger> {

    List<Shop> findAll();
}
