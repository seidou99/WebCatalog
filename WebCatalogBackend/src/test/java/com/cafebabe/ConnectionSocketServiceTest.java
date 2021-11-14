package com.cafebabe;

import com.cafebabe.service.interfaces.ConnectionSocketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
@TestComponent
public class ConnectionSocketServiceTest {

    @Autowired
    protected ConnectionSocketService connectionSocketService;

    @Test
    public void testCreate() {
        ConnectionSockets.ALL.forEach(connectionSocket -> {
            if (!connectionSocketService.findByName(connectionSocket.getName()).isPresent()) {
                connectionSocketService.save(connectionSocket);
            }
        });
    }
}
