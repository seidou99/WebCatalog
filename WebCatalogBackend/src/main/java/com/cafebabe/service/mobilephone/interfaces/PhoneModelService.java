package com.cafebabe.service.mobilephone.interfaces;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.dto.ScreenResolutionDto;
import com.cafebabe.entity.mobilephone.PhoneModel;
import com.cafebabe.service.interfaces.BaseDataObjectService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Root;
import java.util.List;

public interface PhoneModelService extends BaseDataObjectService<PhoneModel> {

    List<Integer> findDistinctMarketLaunchYears();

    List<Double> findDistinctScreenDiagonals();

    List<ScreenResolutionDto> findDistinctScreenResolutions();

    List<Integer> findDistinctScreenRefreshRates();

    List<Integer> findDistinctCamerasAmountVariants();

    List<Float> findDistinctCamerasInMp();

    List<Integer> findDistinctSimCardsAmountVariants();

    List<Integer> findDistinctBatteryCapacities();

    List<Float> findDistinctFrontCameraVariants();

    List<Integer> findDistinctLengthVariants();

    List<Integer> findDistinctWidthVariants();

    List<Integer> findDistinctThicknessVariants();

    List<Integer> findDistinctWeightVariants();

    List<PhoneModel> findFilteredPhoneModelsWithPagination(PhoneModelFilterDto filterDto, int pageIndex, int pageSize);

    Long findFilteredPhoneModelsCount(PhoneModelFilterDto filterDto);

    <T> void buildCriteriaQuery(From<?, PhoneModel> root, PhoneModelFilterDto filterDto, CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery);
}

