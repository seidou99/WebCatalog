package com.cafebabe.service.impl;

import com.cafebabe.model.ConnectionSocket;
import com.cafebabe.repository.ConnectionSocketRepository;
import com.cafebabe.service.interfaces.ConnectionSocketService;
import org.springframework.stereotype.Service;

@Service
public class ConnectionSocketServiceImpl extends BaseDataObjectServiceImpl<ConnectionSocketRepository, ConnectionSocket> implements ConnectionSocketService {
}
