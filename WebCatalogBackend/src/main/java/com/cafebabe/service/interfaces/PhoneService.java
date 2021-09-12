package com.cafebabe.service.interfaces;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.entity.Phone;
import com.cafebabe.service.interfaces.BaseDataObjectService;

import java.util.List;

public interface PhoneService extends BaseDataObjectService<Phone> {

    List<Phone> findFilteredPhones(PhoneFilterDto filterDto, int pageIndex, int pageSize);

    Long findFilteredPhonesCount(PhoneFilterDto phoneFilterDto);
}
