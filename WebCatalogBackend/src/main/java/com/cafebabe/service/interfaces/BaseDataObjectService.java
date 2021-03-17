package com.cafebabe.service.interfaces;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface BaseDataObjectService<T> {

    Optional<T> findById(BigInteger id);

    List<T> findAll();

    T save(T pojo);

    Iterable<T> save(Iterable<T> pojos);
}
