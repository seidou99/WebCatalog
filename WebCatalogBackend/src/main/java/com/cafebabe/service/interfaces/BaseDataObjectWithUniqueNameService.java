package com.cafebabe.service.interfaces;

import com.cafebabe.entity.BaseDataObjectWithUniqueName;

import java.util.Optional;

public interface BaseDataObjectWithUniqueNameService<T extends BaseDataObjectWithUniqueName> extends BaseDataObjectService<T> {


    Optional<T> findByName(String name);
}
