package com.cafebabe.service.impl;

import com.cafebabe.entity.OperationSystemWithVersion;
import com.cafebabe.repository.OperationSystemWithVersionRepository;
import com.cafebabe.service.interfaces.OperationSystemService;
import com.cafebabe.service.interfaces.OperationSystemWithVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationSystemWithVersionServiceImpl extends BaseDataObjectServiceImpl<OperationSystemWithVersionRepository, OperationSystemWithVersion> implements OperationSystemWithVersionService {

    @Autowired
    protected OperationSystemService operationSystemService;

    @Override
    public OperationSystemWithVersion save(OperationSystemWithVersion operationSystemWithVersion) {
        operationSystemService.save(operationSystemWithVersion.getOperationSystem());
        return baseRepository.save(operationSystemWithVersion);
    }

    @Override
    public Optional<OperationSystemWithVersion> findByOperationSystemNameAndVersion(String operationSystemName, String version) {
        return baseRepository.findByOperationSystemNameAndVersion(operationSystemName, version);
    }
}
