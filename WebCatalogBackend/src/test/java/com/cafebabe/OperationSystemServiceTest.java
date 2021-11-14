package com.cafebabe;

import com.cafebabe.service.interfaces.OperationSystemService;
import com.cafebabe.service.interfaces.OperationSystemWithVersionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
@TestComponent
public class OperationSystemServiceTest {

    @Autowired
    protected OperationSystemWithVersionService operationSystemWithVersionService;

    @Autowired
    protected OperationSystemService operationSystemService;

    @Test
    public void testCreate() {
        OperationSystems.ALL_OPERATION_SYSTEMS.forEach(os -> {
            if (!operationSystemService.findByName(os.getName()).isPresent()) {
                operationSystemService.save(os);
            }
        });
        OperationSystems.ALL_OPERATION_SYSTEMS_WITH_VERSIONS.forEach(osWithVersion -> {
            String operationSystemName = osWithVersion.getOperationSystem().getName();
            if (!operationSystemWithVersionService.findByOperationSystemNameAndVersion(operationSystemName, osWithVersion.getVersion()).isPresent()) {
                osWithVersion.setOperationSystem(operationSystemService.findByName(operationSystemName).get());
                operationSystemWithVersionService.save(osWithVersion);
            }
        });
    }
}
