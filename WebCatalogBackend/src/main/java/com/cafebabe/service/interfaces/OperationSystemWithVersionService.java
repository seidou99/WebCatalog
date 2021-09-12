package com.cafebabe.service.interfaces;

import com.cafebabe.entity.OperationSystemWithVersion;

import java.util.Optional;

public interface OperationSystemWithVersionService extends BaseDataObjectService<OperationSystemWithVersion> {

    Optional<OperationSystemWithVersion> findByOperationSystemNameAndVersion(String operationSystemName, String version);
}
