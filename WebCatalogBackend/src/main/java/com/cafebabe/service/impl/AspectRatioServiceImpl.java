package com.cafebabe.service.impl;

import com.cafebabe.entity.digital_technology_common.AspectRatio;
import com.cafebabe.repository.digital_technology_common.AspectRatioRepository;
import com.cafebabe.service.interfaces.AspectRatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class AspectRatioServiceImpl implements AspectRatioService {

    @Autowired
    protected AspectRatioRepository aspectRatioRepository;

    @Override
    public Optional<AspectRatio> findById(BigInteger id) {
        return aspectRatioRepository.findById(id);
    }

    @Override
    public Iterable<AspectRatio> findAll() {
        return aspectRatioRepository.findAll();
    }

    @Override
    public Optional<AspectRatio> findByHorizontalAndVerical(AspectRatio aspectRatio) {
        return aspectRatioRepository.findAspectRatioByHorizontalEqualsAndVerticalEquals(
                aspectRatio.getHorizontal(), aspectRatio.getVertical()
        );
    }

    @Override
    public AspectRatio save(AspectRatio aspectRatio) {
        return aspectRatioRepository.save(aspectRatio);
    }
}
