package com.cafebabe.service.impl;

import com.cafebabe.model.SimCardType;
import com.cafebabe.repository.SimCardTypeRepository;
import com.cafebabe.service.interfaces.SimCardTypeService;
import org.springframework.stereotype.Service;

@Service
public class SimCardTypeServiceImpl extends BaseDataObjectServiceImpl<SimCardTypeRepository, SimCardType> implements SimCardTypeService {
}
