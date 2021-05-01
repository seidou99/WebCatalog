package com.cafebabe.service.mobilephone.impl;

import com.cafebabe.entity.mobilephone.OperationSystem;
import com.cafebabe.repository.mobilephone.OperationSystemRepository;
import com.cafebabe.service.impl.BaseDataObjectServiceImpl;
import com.cafebabe.service.mobilephone.interfaces.OperationSystemService;
import org.springframework.stereotype.Service;

@Service
public class OperationSystemServiceImpl extends BaseDataObjectServiceImpl<OperationSystemRepository, OperationSystem> implements OperationSystemService {
}
