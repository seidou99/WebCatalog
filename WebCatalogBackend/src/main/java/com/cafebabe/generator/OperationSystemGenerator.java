package com.cafebabe.generator;

import com.cafebabe.entity.OperationSystem;
import com.cafebabe.entity.OperationSystemType;
import com.cafebabe.entity.OperationSystemWithVersion;
import com.cafebabe.service.interfaces.OperationSystemService;
import com.cafebabe.service.interfaces.OperationSystemWithVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationSystemGenerator implements GeneratorService {

    @Autowired
    protected OperationSystemWithVersionService operationSystemWithVersionService;

    @Autowired
    protected OperationSystemService operationSystemService;

    public void generate() {
        GeneratorConstants.OperationSystems.ALL_OPERATION_SYSTEMS.forEach(os -> {
            if (!operationSystemService.findByName(os.getName()).isPresent()) {
                operationSystemService.save(os);
            }
        });
        GeneratorConstants.OperationSystems.ALL_OPERATION_SYSTEMS_WITH_VERSIONS.forEach(osWithVersion -> {
            if (!operationSystemWithVersionService.findByOperationSystemNameAndVersion(osWithVersion.getOperationSystem().getName(), osWithVersion.getVersion()).isPresent()) {
                operationSystemWithVersionService.save(osWithVersion);
            }
        });
    }
}
