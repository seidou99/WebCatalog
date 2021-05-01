package com.cafebabe.service.impl;

import com.cafebabe.entity.RamAndRomVariant;
import com.cafebabe.repository.RamAndRomVariantRepository;
import com.cafebabe.service.interfaces.RamAndRomVariantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamAndRomVariantServiceImpl extends BaseDataObjectServiceImpl<RamAndRomVariantRepository, RamAndRomVariant> implements RamAndRomVariantService {

    @Override
    public List<Integer> findDistinctRamVariants() {
        return baseRepository.findDistinctRamVariants();
    }

    @Override
    public List<Integer> findDistinctRomVariants() {
        return baseRepository.findDistinctRomVariants();
    }
}
