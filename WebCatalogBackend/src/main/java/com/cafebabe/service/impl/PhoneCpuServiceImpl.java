package com.cafebabe.service.impl;

import com.cafebabe.entity.phone.PhoneCpu;
import com.cafebabe.repository.CpuRepository;
import com.cafebabe.service.interfaces.CpuCoresBlockService;
import com.cafebabe.service.interfaces.PhoneCpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneCpuServiceImpl extends BaseDataObjectWithUniqueNameServiceImpl<CpuRepository, PhoneCpu> implements PhoneCpuService {

    @Autowired
    protected CpuCoresBlockService cpuCoresBlockService;

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

    @Override
    public PhoneCpu save(PhoneCpu phoneCpu) {
        cpuCoresBlockService.save(phoneCpu.getCoresBlocks());
        return baseRepository.save(phoneCpu);
    }
}
