package com.cafebabe.repository;

import com.cafebabe.entity.BaseDataObjectWithUniqueName;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseDataObjectWithUniqueNameRepository<T extends BaseDataObjectWithUniqueName> extends BaseDataObjectRepository<T> {

    Optional<T> findByName(String name);
}
