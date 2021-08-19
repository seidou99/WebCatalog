package com.cafebabe.service.mobilephone.interfaces;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.entity.Phone;
import com.cafebabe.service.interfaces.BaseDataObjectService;

import java.util.List;

public interface PhoneService extends BaseDataObjectService<Phone> {

    List<Phone> findFilteredPhoneModels(PhoneFilterDto filterDto, int pageIndex, int pageSize);
}
