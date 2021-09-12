package com.cafebabe.repository;

import com.cafebabe.entity.AspectRatio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface AspectRatioRepository extends CrudRepository<AspectRatio, BigInteger> {

    Optional<AspectRatio> findAspectRatioByHorizontalEqualsAndVerticalEquals(float horizontal, float vertical);
}
