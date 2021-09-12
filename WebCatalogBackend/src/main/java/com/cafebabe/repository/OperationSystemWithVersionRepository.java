package com.cafebabe.repository;

import com.cafebabe.entity.OperationSystemWithVersion;

import java.util.Optional;

public interface OperationSystemWithVersionRepository extends BaseDataObjectRepository<OperationSystemWithVersion> {

    Optional<OperationSystemWithVersion> findByOperationSystemNameAndVersion(String operationSystemName, String version);
}
