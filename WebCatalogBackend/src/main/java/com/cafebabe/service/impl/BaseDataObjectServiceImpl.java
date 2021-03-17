package com.cafebabe.service.impl;

import com.cafebabe.repository.BaseDataObjectRepository;
import com.cafebabe.service.interfaces.BaseDataObjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public class BaseDataObjectServiceImpl<S extends BaseDataObjectRepository<T>, T> implements BaseDataObjectService<T> {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected S baseRepository;

    @Override
    public Optional<T> findById(BigInteger id) {
        return baseRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public T save(T pojo) {
        return baseRepository.save(pojo);
    }

    @Override
    public Iterable<T> save(Iterable<T> pojos) {
        return baseRepository.saveAll(pojos);
    }
}
