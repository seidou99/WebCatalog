package com.cafebabe.service.interfaces;

import com.cafebabe.entity.RamAndRomVariant;

import java.util.List;

public interface RamAndRomVariantService extends BaseDataObjectService<RamAndRomVariant> {

    List<Integer> findDistinctRamVariants();

    List<Integer> findDistinctRomVariants();
}
