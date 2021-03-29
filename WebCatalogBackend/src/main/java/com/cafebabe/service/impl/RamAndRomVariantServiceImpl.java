package com.cafebabe.service.impl;

import com.cafebabe.model.RamAndRomVariant;
import com.cafebabe.repository.RamAndRomVariantRepository;
import com.cafebabe.service.interfaces.RamAndRomVariantService;
import org.springframework.stereotype.Service;

@Service
public class RamAndRomVariantServiceImpl extends BaseDataObjectServiceImpl<RamAndRomVariantRepository, RamAndRomVariant> implements RamAndRomVariantService {
}
