package com.cafebabe.service.mobilephone.impl;

import com.cafebabe.model.digital_technology_common.AspectRatio;
import com.cafebabe.model.mobilephone.PhoneModel;
import com.cafebabe.repository.mobilephone.PhoneModelRepository;
import com.cafebabe.service.impl.BaseDataObjectServiceImpl;
import com.cafebabe.service.interfaces.RamAndRomVariantService;
import com.cafebabe.service.interfaces.digital_technology_common.AspectRatioService;
import com.cafebabe.service.mobilephone.interfaces.PhoneModelService;
import com.cafebabe.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneModelServiceImpl extends BaseDataObjectServiceImpl<PhoneModelRepository, PhoneModel>
        implements PhoneModelService {

    @Autowired
    protected RamAndRomVariantService ramAndRomVariantService;

    @Autowired
    protected Util util;

    @Autowired
    protected AspectRatioService aspectRatioService;

    @Override
    public PhoneModel save(PhoneModel phoneModel) {
        ramAndRomVariantService.save(phoneModel.getRamAndRomVariants());
        phoneModel.setScreenPpi(util.calculateScreenPpi(phoneModel));
        AspectRatio aspectRatio = util.calculateScreenAspectRatio(phoneModel);
        Optional<AspectRatio> byHorizontalAndVerical = aspectRatioService.findByHorizontalAndVerical(aspectRatio);
        byHorizontalAndVerical.ifPresent(phoneModel::setAspectRatio);
        byHorizontalAndVerical.orElseGet(() -> {
            AspectRatio save = aspectRatioService.save(aspectRatio);
            phoneModel.setAspectRatio(save);
            return save;
        });
        phoneModel.setAspectRatio(aspectRatio);
        return baseRepository.save(phoneModel);
    }
}
