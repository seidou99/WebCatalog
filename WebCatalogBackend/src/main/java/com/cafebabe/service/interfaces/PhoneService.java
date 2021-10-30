package com.cafebabe.service.interfaces;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.dto.ScreenResolutionDto;
import com.cafebabe.entity.phone.Phone;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface PhoneService {

    Phone update(Phone phone, MultipartFile newMainImageFile, List<MultipartFile> newImages) throws IOException;

    List<Phone> findFilteredPhones(PhoneFilterDto filterDto, int pageIndex, int pageSize);

    Long findFilteredPhonesCount(PhoneFilterDto phoneFilterDto);

    List<Integer> findDistinctMarketLaunchYears();

    List<Float> findDistinctScreenDiagonals();

    List<ScreenResolutionDto> findDistinctScreenResolutions();

    List<Integer> findDistinctScreenRefreshRates();

    List<Float> findDistinctRamVariants();

    List<Float> findDistinctRomVariants();

    List<Integer> findDistinctCamerasAmountVariants();

    List<Float> findDistinctCamerasInMp();

    List<Integer> findDistinctSimCardsAmountVariants();

    List<Integer> findDistinctBatteryCapacities();

    List<Float> findDistinctFrontCameraVariants();

    List<Float> findDistinctLengthVariants();

    List<Float> findDistinctWidthVariants();

    List<Float> findDistinctThicknessVariants();

    List<Float> findDistinctWeightVariants();

    Iterable<Phone> findAll();

    Phone save(Phone phone);

    Phone save(Phone phone, MultipartFile mainImageFile, List<MultipartFile> imagesFiles) throws IOException;

    void delete(BigInteger id) throws IOException;

    Optional<Phone> findById(BigInteger id);

    Optional<Phone> findByName(String name);
}
