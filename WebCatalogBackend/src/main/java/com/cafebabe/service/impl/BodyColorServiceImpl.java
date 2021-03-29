package com.cafebabe.service.impl;

import com.cafebabe.model.BodyColor;
import com.cafebabe.repository.BodyColorRepository;
import com.cafebabe.service.interfaces.BodyColorService;
import org.springframework.stereotype.Service;

@Service
public class BodyColorServiceImpl extends BaseDataObjectServiceImpl<BodyColorRepository, BodyColor> implements BodyColorService {
}
