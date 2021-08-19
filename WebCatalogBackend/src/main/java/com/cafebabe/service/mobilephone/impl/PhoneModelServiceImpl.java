package com.cafebabe.service.mobilephone.impl;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.dto.ScreenResolutionDto;
import com.cafebabe.entity.*;
import com.cafebabe.entity.digital_technology_common.AspectRatio;
import com.cafebabe.entity.mobilephone.PhoneCpu;
import com.cafebabe.entity.mobilephone.PhoneCpu_;
import com.cafebabe.entity.mobilephone.PhoneModel;
import com.cafebabe.entity.mobilephone.PhoneModel_;
import com.cafebabe.repository.mobilephone.PhoneModelRepository;
import com.cafebabe.service.impl.BaseDataObjectServiceImpl;
import com.cafebabe.service.interfaces.AspectRatioService;
import com.cafebabe.service.interfaces.RamAndRomVariantService;
import com.cafebabe.service.mobilephone.interfaces.PhoneModelService;
import com.cafebabe.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneModelServiceImpl extends BaseDataObjectServiceImpl<PhoneModelRepository, PhoneModel>
        implements PhoneModelService {

    @Autowired
    protected RamAndRomVariantService ramAndRomVariantService;

    @Autowired
    protected Util util;

    @Autowired
    protected AspectRatioService aspectRatioService;

    @Autowired
    EntityManager entityManager;

    @Override
    public PhoneModel save(PhoneModel phoneModel) {
        ramAndRomVariantService.save(phoneModel.getRamAndRomVariants());
        phoneModel.setScreenPpi(util.calculateScreenPpi(phoneModel));
        AspectRatio aspectRatio = util.calculateScreenAspectRatio(phoneModel);
//        Optional<AspectRatio> byHorizontalAndVerical = aspectRatioService.findByHorizontalAndVerical(aspectRatio);
//        byHorizontalAndVerical.ifPresent(phoneModel::setAspectRatio);
//        byHorizontalAndVerical.orElseGet(() -> {
//            AspectRatio save = aspectRatioService.save(aspectRatio);
//            phoneModel.setAspectRatio(save);
//            return save;
//        });
//        phoneModel.setAspectRatio(aspectRatio);
        return baseRepository.save(phoneModel);
    }

    @Override
    public List<Integer> findDistinctMarketLaunchYears() {
        return baseRepository.findDistinctMarketLaunchYears();
    }

    @Override
    public List<Double> findDistinctScreenDiagonals() {
        return baseRepository.findDistinctScreenDiagonals();
    }

    @Override
    public List<ScreenResolutionDto> findDistinctScreenResolutions() {
        List<List<Integer>> distinctScreenResolutions = baseRepository.findDistinctScreenResolutions();
        return distinctScreenResolutions.stream().map(horizontalAndVerticalScreenResolution -> new ScreenResolutionDto(horizontalAndVerticalScreenResolution.get(0), horizontalAndVerticalScreenResolution.get(1))).collect(Collectors.toList());
    }

    @Override
    public List<Integer> findDistinctScreenRefreshRates() {
        return baseRepository.findDistinctScreenRefreshRates();
    }

    public List<Integer> findDistinctCamerasAmountVariants() {
        return baseRepository.findDistinctCamerasAmountVariants();
    }

    @Override
    public List<Float> findDistinctCamerasInMp() {
        return baseRepository.findDistinctCamerasInMp();
    }

    @Override
    public List<Integer> findDistinctSimCardsAmountVariants() {
        return baseRepository.findDistinctSimCardsAmountVariants();
    }

    @Override
    public List<Integer> findDistinctBatteryCapacities() {
        return baseRepository.findDistinctBatteryCapacities();
    }

    @Override
    public List<Float> findDistinctFrontCameraVariants() {
        return baseRepository.findDistinctFrontCameraVariants();
    }

    @Override
    public List<Integer> findDistinctLengthVariants() {
        return baseRepository.findDistinctLengthVariants();
    }

    @Override
    public List<Integer> findDistinctWidthVariants() {
        return baseRepository.findDistinctWidthVariants();
    }

    @Override
    public List<Integer> findDistinctThicknessVariants() {
        return baseRepository.findDistinctThicknessVariants();
    }

    @Override
    public List<Integer> findDistinctWeightVariants() {
        return baseRepository.findDistinctWeightVariants();
    }

    @Override
    public List<PhoneModel> findFilteredPhoneModelsWithPagination(PhoneModelFilterDto filterDto, int pageIndex, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PhoneModel> criteriaQuery = criteriaBuilder.createQuery(PhoneModel.class);
        Root<PhoneModel> root = criteriaQuery.from(PhoneModel.class);
        buildCriteriaQuery(root, filterDto, criteriaBuilder, criteriaQuery);
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(pageIndex * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public Long findFilteredPhoneModelsCount(PhoneModelFilterDto filterDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<PhoneModel> root = criteriaQuery.from(PhoneModel.class);
        buildCriteriaQuery(root, filterDto, criteriaBuilder, criteriaQuery);
        CriteriaQuery<Long> select = criteriaQuery.select(criteriaBuilder.countDistinct(root));
        TypedQuery<Long> query = entityManager.createQuery(select);
        return query.getResultList().stream().count();
    }

    public <T> void buildCriteriaQuery(From<?, PhoneModel> root, PhoneModelFilterDto filterDto, CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery) {
        List<Predicate> predicates = new ArrayList<>(40);
        joinAndFilter(root, filterDto.getManufacturers(), predicates, PhoneModel_.MANUFACTURER, Manufacturer_.ID, criteriaBuilder);
        filter(root, filterDto.getMarketLaunchYears(), predicates, PhoneModel_.MARKET_LAUNCH_YEAR, criteriaBuilder);
        filter(root, filterDto.getScreenDiagonalsInInches(), predicates, PhoneModel_.SCREEN_DIAGONAL_IN_INCHES, criteriaBuilder);
        filterScreenResolution(filterDto, criteriaBuilder, root, predicates);
        joinAndFilter(root, filterDto.getScreenTechnologies(), predicates, PhoneModel_.SCREEN_TECHNOLOGY, ScreenTechnology_.ID, criteriaBuilder);
        filter(root, filterDto.getScreenRefreshRates(), predicates, PhoneModel_.SCREEN_REFRESH_RATE, criteriaBuilder);
        filterRamAndRomVariants(filterDto, criteriaBuilder, root, predicates);
        filter(root, filterDto.getIsMemoryCardSupported(), predicates, PhoneModel_.IS_MEMORY_CARD_SUPPORTED, criteriaBuilder);
        filter(root, filterDto.getCamerasAmountVariants(), predicates, PhoneModel_.CAMERAS_AMOUNT, criteriaBuilder);
        filter(root, filterDto.getCamerasInMp(), predicates, PhoneModel_.CAMERA_IN_MP, criteriaBuilder);
        filter(root, filterDto.getSimCardsAmountVariants(), predicates, PhoneModel_.SIM_CARDS_AMOUNT, criteriaBuilder);
        joinAndFilter(root, filterDto.getSimCardTypes(), predicates, PhoneModel_.SIM_CARD_TYPE, SimCardType_.ID, criteriaBuilder);
        joinAndFilter(root, filterDto.getBodyColors(), predicates, PhoneModel_.BODY_COLORS, Color_.ID, criteriaBuilder);
        joinAndFilter(root, filterDto.getDustAndMoistureProtections(), predicates, PhoneModel_.DUST_AND_MOISTURE_PROTECTION, DustAndMoistureProtection_.ID, criteriaBuilder);
        filter(root, filterDto.getBatteryCapacities(), predicates, PhoneModel_.BATTERY_CAPACITY, criteriaBuilder);
        joinAndFilter(root, filterDto.getFingerprintScannerLocations(), predicates, PhoneModel_.FINGERPRINT_SCANNER_LOCATION, FingerprintScannerLocation_.ID, criteriaBuilder);
        joinAndFilter(root, filterDto.getScreenProtections(), predicates, PhoneModel_.SCREEN_PROTECTION, ScreenProtection_.ID, criteriaBuilder);
        joinAndFilter(root, filterDto.getCpuVariants(), predicates, PhoneModel_.CPU, PhoneCpu_.ID, criteriaBuilder);
        filterGpu(filterDto, criteriaBuilder, root, predicates);
        filterCpuCoresAmount(filterDto, criteriaBuilder, predicates, criteriaQuery);
        filterCpuClockSpeed(filterDto, criteriaBuilder, predicates, criteriaQuery);
        filterCpuTechprocess(filterDto, criteriaBuilder, root, predicates);
        filter(root, filterDto.getHasAudioProcessor(), predicates, PhoneModel_.HAS_AUDIO_PROCESSOR, criteriaBuilder);
        filter(root, filterDto.getFrontCameraVariants(), predicates, PhoneModel_.FRONT_CAMERA_IN_MP, criteriaBuilder);
        filter(root, filterDto.getHasAudioOutput(), predicates, PhoneModel_.HAS_AUDIO_OUTPUT, criteriaBuilder);
        joinAndFilter(root, filterDto.getConnectionSocketVariants(), predicates, PhoneModel_.CONNECTION_SOCKET, ConnectionSocket_.ID, criteriaBuilder);
        filter(root, filterDto.getLengthVariants(), predicates, PhoneModel_.LENGTH, criteriaBuilder);
        filter(root, filterDto.getWidthVariants(), predicates, PhoneModel_.WIDTH, criteriaBuilder);
        filter(root, filterDto.getThicknessVariants(), predicates, PhoneModel_.THICKNESS, criteriaBuilder);
        filter(root, filterDto.getWeightVariants(), predicates, PhoneModel_.WEIGHT, criteriaBuilder);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        criteriaQuery.groupBy(root.get(PhoneModel_.id));
    }

    protected <T extends BaseDataObjectWithName> void joinAndFilter(From<?, ?> root, List<T> entities, List<Predicate> predicates, String joinEntityPath, String joinEntityIdPath, CriteriaBuilder criteriaBuilder) {
        Join<Object, Object> join = root.join(joinEntityPath);
        if (entities.size() != 0) {
            CriteriaBuilder.In<BigInteger> inPredicate = criteriaBuilder.in(join.get(joinEntityIdPath));
            entities.forEach(entity -> inPredicate.value(entity.getId()));
            predicates.add(inPredicate);
        }
    }

    protected <T extends Number> void filter(From<?, ?> root, List<T> filter, List<Predicate> predicates, String fieldPath, CriteriaBuilder criteriaBuilder) {
        if (filter.size() != 0) {
            CriteriaBuilder.In<Number> in = criteriaBuilder.in(root.get(fieldPath));
            filter.forEach(in::value);
            predicates.add(in);
        }
    }

    protected void filter(From<?, ?> root, Boolean filter, List<Predicate> predicates, String fieldPath, CriteriaBuilder criteriaBuilder) {
        if (filter != null) {
            Predicate equalPredicate = criteriaBuilder.equal(root.get(fieldPath), filter);
            predicates.add(equalPredicate);
        }
    }

    protected void filterScreenResolution(PhoneModelFilterDto filterDto, CriteriaBuilder criteriaBuilder, From<?, PhoneModel> root, List<Predicate> predicates) {
        if (filterDto.getScreenResolutions().size() != 0) {
            List<Predicate> horizontalAndVerticalScreenResolutionPredicates = new ArrayList<>(filterDto.getScreenResolutions().size());
            for (ScreenResolutionDto screenResolutionDto : filterDto.getScreenResolutions()) {
                Predicate horizontalScreenResolutionPredicate = criteriaBuilder.equal(root.get(PhoneModel_.horizontalScreenResolution), screenResolutionDto.getHorizontal());
                Predicate verticalScreenResolutionPredicate = criteriaBuilder.equal(root.get(PhoneModel_.verticalScreenResolution), screenResolutionDto.getVertical());
                Predicate horizontalAndVerticalScreenResolutionPredicate = criteriaBuilder.and(horizontalScreenResolutionPredicate, verticalScreenResolutionPredicate);
                horizontalAndVerticalScreenResolutionPredicates.add(horizontalAndVerticalScreenResolutionPredicate);
            }
            Predicate screenResolutionPredicate = criteriaBuilder.or(horizontalAndVerticalScreenResolutionPredicates.toArray(new Predicate[0]));
            predicates.add(screenResolutionPredicate);
        }
    }

    protected void filterRamAndRomVariants(PhoneModelFilterDto filterDto, CriteriaBuilder criteriaBuilder, From<?, PhoneModel> root, List<Predicate> predicates) {
        List<Integer> ramVariants = filterDto.getRamVariants();
        List<Integer> romVariants = filterDto.getRomVariants();
        ListJoin<PhoneModel, RamAndRomVariant> join = root.join(PhoneModel_.ramAndRomVariants);
        if (ramVariants.size() != 0) {
            CriteriaBuilder.In<Integer> ramSizePredicate = criteriaBuilder.in(join.get(RamAndRomVariant_.ramSizeInGb));
            ramVariants.forEach(ramSizePredicate::value);
            predicates.add(ramSizePredicate);
        }
        if (romVariants.size() != 0) {
            CriteriaBuilder.In<Integer> romSizePredicate = criteriaBuilder.in(join.get(RamAndRomVariant_.ROM_SIZE_IN_GB));
            romVariants.forEach(romSizePredicate::value);
            predicates.add(romSizePredicate);
        }
    }

    protected void filterGpu(PhoneModelFilterDto filterDto, CriteriaBuilder criteriaBuilder, From<?, PhoneModel> root, List<Predicate> predicates) {
        if (filterDto.getPhoneGpuVariants().size() != 0) {
            Join<PhoneModel, PhoneCpu> phoneModelToPhoneCpuJoin = root.join(PhoneModel_.cpu);
            Join<PhoneCpu, PhoneGpu> phoneCpuToPhoneGpuJoin = phoneModelToPhoneCpuJoin.join(PhoneCpu_.integratedGpu);
            CriteriaBuilder.In<BigInteger> gpuPredicate = criteriaBuilder.in(phoneCpuToPhoneGpuJoin.get(PhoneGpu_.id));
            filterDto.getPhoneGpuVariants().forEach(gpu -> gpuPredicate.value(gpu.getId()));
            predicates.add(gpuPredicate);
        }
    }

    protected void filterCpuTechprocess(PhoneModelFilterDto filterDto, CriteriaBuilder criteriaBuilder, From<?, PhoneModel> root, List<Predicate> predicates) {
        if (filterDto.getCpuTechprocessVariants().size() != 0) {
            Join<PhoneModel, PhoneCpu> phoneModelToPhoneCpuJoin = root.join(PhoneModel_.cpu);
            CriteriaBuilder.In<Integer> cpuTechprocessPredicate = criteriaBuilder.in(phoneModelToPhoneCpuJoin.get(PhoneCpu_.TECHPROCESS_IN_NM));
            filterDto.getCpuTechprocessVariants().forEach(cpuTechprocessPredicate::value);
            predicates.add(cpuTechprocessPredicate);
        }
    }

    protected void filterCpuCoresAmount(PhoneModelFilterDto filterDto, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, CriteriaQuery<?> criteriaQuery) {
        if (filterDto.getCoresAmountVariants().size() != 0) {
            Subquery<Integer> subquery = criteriaQuery.subquery(Integer.class);
            Root<PhoneCpu> subRoot = subquery.from(PhoneCpu.class);
            ListJoin<PhoneCpu, CpuCoresBlock> phoneCpuToCoresBlocksJoin = subRoot.join(PhoneCpu_.coresBlocks);
            subquery.select(criteriaBuilder.sum(phoneCpuToCoresBlocksJoin.get(CpuCoresBlock_.CORES_AMOUNT)));
            CriteriaBuilder.In<Integer> coresAmountPredicate = criteriaBuilder.in(subquery);
            filterDto.getCoresAmountVariants().forEach(coresAmountPredicate::value);
            predicates.add(coresAmountPredicate);
        }
    }

    protected void filterCpuClockSpeed(PhoneModelFilterDto filterDto, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, CriteriaQuery<?> criteriaQuery) {
        if (filterDto.getCpuClockSpeedVariants().size() != 0) {
            Subquery<Integer> subquery = criteriaQuery.subquery(Integer.class);
            Root<PhoneCpu> subRoot = subquery.from(PhoneCpu.class);
            ListJoin<PhoneCpu, CpuCoresBlock> phoneCpuToCoresBlocksJoin = subRoot.join(PhoneCpu_.coresBlocks);
            subquery.select(criteriaBuilder.max(phoneCpuToCoresBlocksJoin.get(CpuCoresBlock_.CLOCK_SPEED_IN_MHZ)));
            CriteriaBuilder.In<Integer> clockSpeedPredicate = criteriaBuilder.in(subquery);
            filterDto.getCpuClockSpeedVariants().forEach(clockSpeedPredicate::value);
            predicates.add(clockSpeedPredicate);
        }
    }

}
