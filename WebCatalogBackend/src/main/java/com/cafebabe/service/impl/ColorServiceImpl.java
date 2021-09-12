package com.cafebabe.service.impl;

import com.cafebabe.entity.Color;
import com.cafebabe.repository.ColorRepository;
import com.cafebabe.service.interfaces.ColorService;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl extends BaseDataObjectWithUniqueNameServiceImpl<ColorRepository, Color> implements ColorService {
}
