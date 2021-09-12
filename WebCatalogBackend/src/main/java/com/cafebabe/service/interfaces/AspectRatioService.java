package com.cafebabe.service.interfaces;

import com.cafebabe.entity.AspectRatio;

import java.math.BigInteger;
import java.util.Optional;

public interface AspectRatioService {

    Optional<AspectRatio> findById(BigInteger id);

    Iterable<AspectRatio> findAll();

    Optional<AspectRatio> findByHorizontalAndVerical(AspectRatio aspectRatio);

    AspectRatio save(AspectRatio aspectRatio);
}
