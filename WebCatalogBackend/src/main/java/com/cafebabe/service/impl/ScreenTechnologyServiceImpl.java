package com.cafebabe.service.impl;

import com.cafebabe.model.ScreenTechnology;
import com.cafebabe.repository.ScreenTechnologyRepository;
import com.cafebabe.service.interfaces.ScreenTechnologyService;
import org.springframework.stereotype.Service;

@Service
public class ScreenTechnologyServiceImpl extends BaseDataObjectServiceImpl<ScreenTechnologyRepository, ScreenTechnology> implements ScreenTechnologyService {
}
