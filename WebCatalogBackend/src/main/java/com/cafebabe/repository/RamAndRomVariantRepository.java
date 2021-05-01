package com.cafebabe.repository;

import com.cafebabe.entity.RamAndRomVariant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RamAndRomVariantRepository extends BaseDataObjectRepository<RamAndRomVariant> {

    @Query("select distinct r.ramSizeInGb from RamAndRomVariant r")
    List<Integer> findDistinctRamVariants();

    @Query("select distinct r.romSizeInGb from RamAndRomVariant r")
    List<Integer> findDistinctRomVariants();

}
