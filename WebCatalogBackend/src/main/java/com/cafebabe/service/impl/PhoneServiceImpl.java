package com.cafebabe.service.impl;

import com.cafebabe.entity.Phone;
import com.cafebabe.repository.PhoneRepository;
import com.cafebabe.service.interfaces.PhoneService;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl extends BaseDataObjectServiceImpl<PhoneRepository, Phone> implements PhoneService {
}
