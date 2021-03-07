package com.cafebabe.service.mobilephone.impl;

import com.cafebabe.model.mobilephone.OperationSystemWithVersion;
import com.cafebabe.repository.OperationSystemWithVersionRepository;
import com.cafebabe.service.impl.BaseDataObjectServiceImpl;
import com.cafebabe.service.mobilephone.interfaces.OperationSystemService;
import com.cafebabe.service.mobilephone.interfaces.OperationSystemWithVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationSystemWithVersionServiceImpl extends BaseDataObjectServiceImpl<OperationSystemWithVersionRepository, OperationSystemWithVersion> implements OperationSystemWithVersionService {

    @Autowired
    protected OperationSystemService operationSystemService;

    @Override
    public OperationSystemWithVersion save(OperationSystemWithVersion operationSystemWithVersion) {
        operationSystemService.save(operationSystemWithVersion.getOperationSystem());
        return baseRepository.save(operationSystemWithVersion);
    }
}
