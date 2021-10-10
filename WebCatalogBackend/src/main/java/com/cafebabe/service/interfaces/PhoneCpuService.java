package com.cafebabe.service.interfaces;

import com.cafebabe.entity.phone.PhoneCpu;

import java.util.List;

public interface PhoneCpuService extends BaseDataObjectWithUniqueNameService<PhoneCpu> {

    List<Integer> findDistinctCoresAmountVariants();

    List<Integer> findDistinctCpuClockSpeedVariants();

    List<Integer> findDistinctCpuTechprocessVariants();
}
