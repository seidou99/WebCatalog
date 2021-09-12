package com.cafebabe.service.interfaces;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.dto.ScreenResolutionDto;
import com.cafebabe.entity.PhoneModel;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import java.io.IOException;
import java.util.List;

public interface PhoneModelService extends BaseDataObjectWithUniqueNameService<PhoneModel> {

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

    PhoneModel save(PhoneModel phoneModel, List<MultipartFile> phoneModelImageFiles) throws IOException;
}

