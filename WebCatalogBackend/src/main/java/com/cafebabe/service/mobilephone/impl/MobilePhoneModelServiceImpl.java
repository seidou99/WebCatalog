package com.cafebabe.service.mobilephone.impl;

import com.cafebabe.model.mobilephone.MobilePhoneModel;
import com.cafebabe.repository.mobilephone.MobilePhoneModelRepository;
import com.cafebabe.service.impl.BaseDataObjectServiceImpl;
import com.cafebabe.service.mobilephone.interfaces.MobilePhoneModelService;
import org.springframework.stereotype.Service;

@Service
public class MobilePhoneModelServiceImpl extends BaseDataObjectServiceImpl<MobilePhoneModelRepository, MobilePhoneModel>
        implements MobilePhoneModelService {
}
