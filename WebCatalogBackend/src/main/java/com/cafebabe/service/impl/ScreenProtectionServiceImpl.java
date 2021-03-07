package com.cafebabe.service.impl;

import com.cafebabe.model.ScreenProtection;
import com.cafebabe.repository.ScreenProtectionRepository;
import com.cafebabe.service.interfaces.ScreenProtectionService;
import org.springframework.stereotype.Service;

@Service
public class ScreenProtectionServiceImpl extends BaseDataObjectServiceImpl<ScreenProtectionRepository, ScreenProtection> implements ScreenProtectionService {
}
