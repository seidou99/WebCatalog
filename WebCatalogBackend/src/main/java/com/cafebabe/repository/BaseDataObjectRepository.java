package com.cafebabe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.math.BigInteger;
import java.util.List;

@NoRepositoryBean
public interface BaseDataObjectRepository<T> extends CrudRepository<T, BigInteger> {

    @Override
    List<T> findAll();
}
