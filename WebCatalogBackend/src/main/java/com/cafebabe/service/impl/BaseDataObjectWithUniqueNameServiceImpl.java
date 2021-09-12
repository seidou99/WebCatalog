package com.cafebabe.service.impl;

import com.cafebabe.entity.BaseDataObjectWithUniqueName;
import com.cafebabe.repository.BaseDataObjectWithUniqueNameRepository;
import com.cafebabe.service.interfaces.BaseDataObjectWithUniqueNameService;

import java.util.Optional;

public class BaseDataObjectWithUniqueNameServiceImpl<S extends BaseDataObjectWithUniqueNameRepository<T>, T extends BaseDataObjectWithUniqueName> extends BaseDataObjectServiceImpl<S, T> implements BaseDataObjectWithUniqueNameService<T> {

    @Override
    public Optional<T> findByName(String name) {
        return baseRepository.findByName(name);
    }
}
