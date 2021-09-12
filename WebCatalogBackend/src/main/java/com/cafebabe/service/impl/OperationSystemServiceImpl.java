package com.cafebabe.service.impl;

import com.cafebabe.entity.OperationSystem;
import com.cafebabe.repository.OperationSystemRepository;
import com.cafebabe.service.interfaces.OperationSystemService;
import org.springframework.stereotype.Service;

@Service
public class OperationSystemServiceImpl extends BaseDataObjectWithUniqueNameServiceImpl<OperationSystemRepository, OperationSystem> implements OperationSystemService {
}
