package com.cafebabe.service.impl;

import com.cafebabe.entity.Color;
import com.cafebabe.repository.BodyColorRepository;
import com.cafebabe.service.interfaces.ColorService;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl extends BaseDataObjectServiceImpl<BodyColorRepository, Color> implements ColorService {
}
