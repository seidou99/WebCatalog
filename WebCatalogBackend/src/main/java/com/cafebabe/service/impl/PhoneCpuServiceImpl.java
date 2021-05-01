package com.cafebabe.service.impl;

import com.cafebabe.entity.mobilephone.PhoneCpu;
import com.cafebabe.repository.CpuRepository;
import com.cafebabe.service.interfaces.PhoneCpuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneCpuServiceImpl extends BaseDataObjectServiceImpl<CpuRepository, PhoneCpu> implements PhoneCpuService {

    @Override
    public List<Integer> findDistinctCoresAmountVariants() {
        return baseRepository.findDistinctCoresAmountVariants();
    }

    @Override
    public List<Integer> findDistinctCpuClockSpeedVariants() {
        return baseRepository.findDistinctCpuClockSpeedVariants();
    }

    @Override
    public List<Integer> findDistinctCpuTechprocessVariants() {
        return baseRepository.findDistinctCpuTechprocessVariants();
    }
}
