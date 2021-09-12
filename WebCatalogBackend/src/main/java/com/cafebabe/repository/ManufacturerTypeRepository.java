package com.cafebabe.repository;

import com.cafebabe.entity.ManufacturerType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerTypeRepository extends BaseDataObjectWithUniqueNameRepository<ManufacturerType> {

    List<ManufacturerType> findAllByNameIn(List<String> names);
}
