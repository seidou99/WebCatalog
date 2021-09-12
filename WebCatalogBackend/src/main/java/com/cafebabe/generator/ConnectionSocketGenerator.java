package com.cafebabe.generator;

import com.cafebabe.service.interfaces.ConnectionSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionSocketGenerator implements GeneratorService {

    @Autowired
    protected ConnectionSocketService connectionSocketService;

    public void generate() {
        GeneratorConstants.ConnectionSockets.ALL.forEach(connectionSocket -> {
            if (!connectionSocketService.findByName(connectionSocket.getName()).isPresent()) {
                connectionSocketService.save(connectionSocket);
            }
        });
    }
}
