package com.cafebabe.repository;

import com.cafebabe.entity.BaseDataObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.math.BigInteger;
import java.util.List;

@NoRepositoryBean
public interface BaseDataObjectRepository<T extends BaseDataObject> extends CrudRepository<T, BigInteger> {

    @Override
    List<T> findAll();
}
