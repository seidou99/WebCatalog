package com.cafebabe.service.interfaces;

import com.cafebabe.entity.mobilephone.PhoneCpu;

import java.util.List;

public interface PhoneCpuService extends BaseDataObjectService<PhoneCpu>{

    List<Integer> findDistinctCoresAmountVariants();

    List<Integer> findDistinctCpuClockSpeedVariants();

    List<Integer> findDistinctCpuTechprocessVariants();
}
