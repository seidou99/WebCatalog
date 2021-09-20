package com.cafebabe.repository;

import com.cafebabe.entity.OperationSystemWithVersion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface OperationSystemWithVersionRepository extends CrudRepository<OperationSystemWithVersion, BigInteger>, BaseDataObjectRepository<OperationSystemWithVersion> {

    @Query("select osv from OperationSystemWithVersion osv join fetch OperationSystem os where os.name = ?1 and osv.version = ?2")
    Optional<OperationSystemWithVersion> findByOperationSystemNameAndVersion(String operationSystemName, String version);
}
