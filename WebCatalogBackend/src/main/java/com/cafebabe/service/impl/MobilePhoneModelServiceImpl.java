package com.cafebabe.service.impl;

import com.cafebabe.model.mobilephone.MobilePhoneModel;
import com.cafebabe.repository.MobilePhoneModelRepository;
import com.cafebabe.service.MobilePhoneModelService;
import org.springframework.stereotype.Service;

@Service
public class MobilePhoneModelServiceImpl extends BaseDataObjectServiceImpl<MobilePhoneModelRepository, MobilePhoneModel>
        implements MobilePhoneModelService {
}
