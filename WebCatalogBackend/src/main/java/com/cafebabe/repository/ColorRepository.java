package com.cafebabe.repository;

import com.cafebabe.entity.Color;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends BaseDataObjectWithUniqueNameRepository<Color> {
}
