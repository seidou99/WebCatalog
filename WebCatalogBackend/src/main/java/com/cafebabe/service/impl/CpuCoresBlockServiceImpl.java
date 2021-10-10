package com.cafebabe.service.impl;

import com.cafebabe.entity.phone.CpuCoresBlock;
import com.cafebabe.repository.CpuCoresBlockRepository;
import com.cafebabe.service.interfaces.CpuCoresBlockService;
import org.springframework.stereotype.Service;

@Service
public class CpuCoresBlockServiceImpl extends BaseDataObjectServiceImpl<CpuCoresBlockRepository, CpuCoresBlock> implements CpuCoresBlockService {
}
