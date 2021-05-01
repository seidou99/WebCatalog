package com.cafebabe.controller.mobilephone;

import com.cafebabe.entity.ConnectionSocket;
import com.cafebabe.service.interfaces.ConnectionSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConnectionSocketController {

    @Autowired
    protected ConnectionSocketService connectionSocketService;

    @GetMapping("api/connection-sockets")
    public List<ConnectionSocket> getAll() {
        return connectionSocketService.findAll();
    }

    @PostMapping("api/connection-sockets")
    public void save(@RequestBody ConnectionSocket connectionSocket) {
        connectionSocketService.save(connectionSocket);
    }
}
