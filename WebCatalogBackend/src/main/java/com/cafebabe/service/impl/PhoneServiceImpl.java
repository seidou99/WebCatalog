package com.cafebabe.service.impl;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.dto.ScreenResolutionDto;
import com.cafebabe.entity.BaseDataObject;
import com.cafebabe.entity.BaseDataObject_;
import com.cafebabe.entity.Image;
import com.cafebabe.entity.phone.*;
import com.cafebabe.repository.PhoneRepository;
import com.cafebabe.service.interfaces.ImageService;
import com.cafebabe.service.interfaces.PhoneService;
import com.cafebabe.util.Util;
import org.hibernate.collection.internal.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    protected EntityManager entityManager;

    @Autowired
    protected PhoneRepository phoneRepository;

    @Autowired
    protected ImageService imageService;

    @Override
    public Iterable<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findByName(String name) {
        return phoneRepository.findByName(name);
    }

    @Override
    public Phone save(Phone phone) {
        phone.setScreenPpi(Util.calculateScreenPpi(phone));
        return phoneRepository.save(phone);
    }

    @Override
    public void delete(BigInteger id) throws IOException {
        Phone phone = findById(id).get();
        Image mainImage = phone.getMainImage();
        List<Image> images = phone.getImages();
        //dirty hack to init persistent bag
        images.size();
        phoneRepository.delete(phone);
        imageService.deleteImages(images);
        imageService.deleteImage(mainImage);
    }

    @Override
    public Optional<Phone> findById(BigInteger id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone, MultipartFile mainImageFile, List<MultipartFile> imagesFiles) throws IOException {
        if (imagesFiles != null) {
            List<Image> images = imageService.saveImages(imagesFiles);
            phone.setImages(images);
        }
        Image mainImage = imageService.saveImages(Collections.singletonList(mainImageFile)).get(0);
        phone.setMainImage(mainImage);
        return save(phone);
    }

    @Override
    public Phone update(Phone phone, MultipartFile newMainImageFile, List<MultipartFile> newImages) throws IOException {
        Optional<Phone> oldPhone = phoneRepository.findById(phone.getId());
        Image mainImageToDelete = null;
        List<Image> imagesToDelete = null;
        if (newMainImageFile != null) {
            mainImageToDelete = oldPhone.get().getMainImage();
            Image mainImage = imageService.saveImage(newMainImageFile);
            phone.setMainImage(mainImage);
        }
        if (newImages != null && newImages.size() != 0) {
            List<Image> savedImages = imageService.saveImages(newImages);
            imagesToDelete = oldPhone.get().getImages().stream().filter(oldImage -> phone.getImages().stream().noneMatch(image -> image.getId().equals(oldImage.getId()))).collect(Collectors.toList());
            phone.getImages().addAll(savedImages);
        }
        phoneRepository.save(phone);
        if (mainImageToDelete != null) {
            imageService.deleteImage(mainImageToDelete);
        }
        if (imagesToDelete != null && !imagesToDelete.isEmpty()) {
            imageService.deleteImages(imagesToDelete);
        }
        return phone;
    }

    @Override
    public List<Phone> findFilteredPhones(PhoneFilterDto filterDto, int pageIndex, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> criteriaQuery = criteriaBuilder.createQuery(Phone.class);
        Root<Phone> phoneRoot = criteriaQuery.from(Phone.class);
        buildCriteriaQuery(phoneRoot, filterDto, criteriaBuilder, criteriaQuery);
        TypedQuery<Phone> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(pageIndex * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public Long findFilteredPhonesCount(PhoneFilterDto filterDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Phone> root = criteriaQuery.from(Phone.class);
        buildCriteriaQuery(root, filterDto, criteriaBuilder, criteriaQuery);
        CriteriaQuery<Long> select = criteriaQuery.select(criteriaBuilder.countDistinct(root));
        TypedQuery<Long> query = entityManager.createQuery(select);
        return query.getSingleResult();
    }

    protected void buildCriteriaQuery(Root<Phone> root, PhoneFilterDto filterDto, CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery) {
        Predicate[] predicates = Stream.of(
                        joinAndFilter(root, filterDto.getManufacturers(), Phone_.MANUFACTURER, criteriaBuilder),
                        filter(root, filterDto.getMarketLaunchYears(), Phone_.MARKET_LAUNCH_YEAR, criteriaBuilder),
                        filter(root, filterDto.getScreenDiagonalsInInches(), Phone_.SCREEN_DIAGONAL_IN_INCHES, criteriaBuilder),
                        filterScreenResolution(root, filterDto.getScreenResolutions(), criteriaBuilder),
                        joinAndFilter(root, filterDto.getScreenTechnologies(), Phone_.SCREEN_TECHNOLOGY, criteriaBuilder),
                        filter(root, filterDto.getScreenRefreshRates(), Phone_.SCREEN_REFRESH_RATE, criteriaBuilder),
                        filter(root, filterDto.getIsMemoryCardSupported(), Phone_.IS_MEMORY_CARD_SUPPORTED, criteriaBuilder),
                        filter(root, filterDto.getCamerasAmountVariants(), Phone_.CAMERAS_AMOUNT, criteriaBuilder),
                        filter(root, filterDto.getCamerasInMp(), Phone_.CAMERA_IN_MP, criteriaBuilder),
                        filter(root, filterDto.getSimCardsAmountVariants(), Phone_.SIM_CARDS_AMOUNT, criteriaBuilder),
                        joinAndFilter(root, filterDto.getSimCardTypes(), Phone_.SIM_CARD_TYPE, criteriaBuilder),
                        joinAndFilter(root, filterDto.getBodyColors(), Phone_.BODY_COLOR, criteriaBuilder),
                        leftJoinAndFilter(root, filterDto.getDustAndMoistureProtections(), Phone_.DUST_AND_MOISTURE_PROTECTION, criteriaBuilder),
                        filter(root, filterDto.getBatteryCapacities(), Phone_.BATTERY_CAPACITY, criteriaBuilder),
                        leftJoinAndFilter(root, filterDto.getFingerprintScannerLocations(), Phone_.FINGERPRINT_SCANNER_LOCATION, criteriaBuilder),
                        leftJoinAndFilter(root, filterDto.getScreenProtections(), Phone_.SCREEN_PROTECTION, criteriaBuilder),
                        joinAndFilter(root, filterDto.getCpuVariants(), Phone_.CPU, criteriaBuilder),
                        filter(root, filterDto.getRamVariants(), Phone_.RAM_SIZE_IN_GB, criteriaBuilder),
                        filter(root, filterDto.getRomVariants(), Phone_.ROM_SIZE_IN_GB, criteriaBuilder),
                        filterGpu(root, filterDto.getPhoneGpuVariants(), criteriaBuilder),
                        filterCpuCoresAmount(filterDto.getCoresAmountVariants(), criteriaBuilder, criteriaQuery),
                        filterCpuClockSpeed(filterDto.getCpuClockSpeedVariants(), criteriaBuilder, criteriaQuery),
                        filterCpuTechprocess(root, filterDto.getCpuTechprocessVariants(), criteriaBuilder),
                        filter(root, filterDto.getFrontCameraVariants(), Phone_.FRONT_CAMERA_IN_MP, criteriaBuilder),
                        filter(root, filterDto.getHasAudioOutput(), Phone_.HAS_AUDIO_OUTPUT, criteriaBuilder),
                        joinAndFilter(root, filterDto.getConnectionSocketVariants(), Phone_.CONNECTION_SOCKET, criteriaBuilder),
                        filter(root, filterDto.getLengthVariants(), Phone_.LENGTH, criteriaBuilder),
                        filter(root, filterDto.getWidthVariants(), Phone_.WIDTH, criteriaBuilder),
                        filter(root, filterDto.getThicknessVariants(), Phone_.THICKNESS, criteriaBuilder),
                        filter(root, filterDto.getWeightVariants(), Phone_.WEIGHT, criteriaBuilder))
                .filter(Objects::nonNull)
                .toArray(Predicate[]::new);
        criteriaQuery.where(predicates);
    }

    protected <T extends BaseDataObject> CriteriaBuilder.In<BigInteger> joinAndFilter(From<?, ?> root, List<T> entities, String joinEntityPath, CriteriaBuilder criteriaBuilder) {
        Join<Object, Object> join = root.join(joinEntityPath);
        CriteriaBuilder.In<BigInteger> inPredicate = null;
        if (entities.size() != 0) {
            inPredicate = criteriaBuilder.in(join.get(BaseDataObject_.ID));
            for (T entity : entities) {
                inPredicate.value(entity.getId());
            }
        }
        return inPredicate;
    }

    protected <T extends BaseDataObject> CriteriaBuilder.In<BigInteger> leftJoinAndFilter(From<?, ?> root, List<T> entities, String joinEntityPath, CriteriaBuilder criteriaBuilder) {
        Join<Object, Object> join = root.join(joinEntityPath, JoinType.LEFT);
        CriteriaBuilder.In<BigInteger> inPredicate = null;
        if (entities.size() != 0) {
            inPredicate = criteriaBuilder.in(join.get(BaseDataObject_.ID));
            for (T entity : entities) {
                inPredicate.value(entity.getId());
            }
        }
        return inPredicate;
    }

    protected <T extends Number> CriteriaBuilder.In<Number> filter(From<?, ?> root, List<T> filter, String fieldPath, CriteriaBuilder criteriaBuilder) {
        CriteriaBuilder.In<Number> in = null;
        if (filter.size() != 0) {
            in = criteriaBuilder.in(root.get(fieldPath));
            filter.forEach(in::value);
        }
        return in;
    }

    protected Predicate filter(From<?, ?> root, Boolean filter, String fieldPath, CriteriaBuilder criteriaBuilder) {
        Predicate equalPredicate = null;
        if (filter != null) {
            equalPredicate = criteriaBuilder.equal(root.get(fieldPath), filter);
        }
        return equalPredicate;
    }

    protected Predicate filterScreenResolution(From<?, Phone> root, List<ScreenResolutionDto> screenResolutions, CriteriaBuilder criteriaBuilder) {
        Predicate screenResolutionPredicate = null;
        if (screenResolutions.size() != 0) {
            List<Predicate> horizontalAndVerticalScreenResolutionPredicates = new ArrayList<>(screenResolutions.size());
            for (ScreenResolutionDto screenResolutionDto : screenResolutions) {
                Predicate horizontalScreenResolutionPredicate = criteriaBuilder.equal(root.get(Phone_.horizontalScreenResolution), screenResolutionDto.getHorizontal());
                Predicate verticalScreenResolutionPredicate = criteriaBuilder.equal(root.get(Phone_.verticalScreenResolution), screenResolutionDto.getVertical());
                Predicate horizontalAndVerticalScreenResolutionPredicate = criteriaBuilder.and(horizontalScreenResolutionPredicate, verticalScreenResolutionPredicate);
                horizontalAndVerticalScreenResolutionPredicates.add(horizontalAndVerticalScreenResolutionPredicate);
            }
            screenResolutionPredicate = criteriaBuilder.or(horizontalAndVerticalScreenResolutionPredicates.toArray(new Predicate[0]));
        }
        return screenResolutionPredicate;
    }

    protected CriteriaBuilder.In<BigInteger> filterGpu(From<?, Phone> root, List<PhoneGpu> phoneGpus, CriteriaBuilder criteriaBuilder) {
        CriteriaBuilder.In<BigInteger> gpuPredicate = null;
        if (phoneGpus.size() != 0) {
            Join<Phone, PhoneCpu> phoneModelToPhoneCpuJoin = root.join(Phone_.cpu);
            Join<PhoneCpu, PhoneGpu> phoneCpuToPhoneGpuJoin = phoneModelToPhoneCpuJoin.join(PhoneCpu_.integratedGpu);
            gpuPredicate = criteriaBuilder.in(phoneCpuToPhoneGpuJoin.get(PhoneGpu_.id));
            for (PhoneGpu gpu : phoneGpus) {
                gpuPredicate.value(gpu.getId());
            }
        }
        return gpuPredicate;
    }

    protected CriteriaBuilder.In<Integer> filterCpuTechprocess(From<?, Phone> root, List<Integer> cpuTechprocessVariants, CriteriaBuilder criteriaBuilder) {
        CriteriaBuilder.In<Integer> cpuTechprocessPredicate = null;
        if (cpuTechprocessVariants.size() != 0) {
            Join<Phone, PhoneCpu> phoneModelToPhoneCpuJoin = root.join(Phone_.cpu);
            cpuTechprocessPredicate = criteriaBuilder.in(phoneModelToPhoneCpuJoin.get(PhoneCpu_.TECHPROCESS_IN_NM));
            cpuTechprocessVariants.forEach(cpuTechprocessPredicate::value);
        }
        return cpuTechprocessPredicate;
    }

    protected CriteriaBuilder.In<Integer> filterCpuCoresAmount(List<Integer> coreAmountVariants, CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery) {
        CriteriaBuilder.In<Integer> coresAmountPredicate = null;
        if (coreAmountVariants.size() != 0) {
            Subquery<Integer> subquery = criteriaQuery.subquery(Integer.class);
            Root<PhoneCpu> subRoot = subquery.from(PhoneCpu.class);
            ListJoin<PhoneCpu, CpuCoresBlock> phoneCpuToCoresBlocksJoin = subRoot.join(PhoneCpu_.coresBlocks);
            subquery.select(criteriaBuilder.sum(phoneCpuToCoresBlocksJoin.get(CpuCoresBlock_.CORES_AMOUNT)));
            coresAmountPredicate = criteriaBuilder.in(subquery);
            coreAmountVariants.forEach(coresAmountPredicate::value);
        }
        return coresAmountPredicate;
    }

    protected CriteriaBuilder.In<Integer> filterCpuClockSpeed(List<Integer> cpuClockSpeedVariants, CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery) {
        CriteriaBuilder.In<Integer> clockSpeedPredicate = null;
        if (cpuClockSpeedVariants.size() != 0) {
            Subquery<Integer> subquery = criteriaQuery.subquery(Integer.class);
            Root<PhoneCpu> subRoot = subquery.from(PhoneCpu.class);
            ListJoin<PhoneCpu, CpuCoresBlock> phoneCpuToCoresBlocksJoin = subRoot.join(PhoneCpu_.coresBlocks);
            subquery.select(criteriaBuilder.max(phoneCpuToCoresBlocksJoin.get(CpuCoresBlock_.CLOCK_SPEED_IN_MHZ)));
            clockSpeedPredicate = criteriaBuilder.in(subquery);
            cpuClockSpeedVariants.forEach(clockSpeedPredicate::value);
        }
        return clockSpeedPredicate;
    }

    @Override
    public List<Integer> findDistinctMarketLaunchYears() {
        return phoneRepository.findDistinctMarketLaunchYears();
    }

    @Override
    public List<Float> findDistinctScreenDiagonals() {
        return phoneRepository.findDistinctScreenDiagonals();
    }

    @Override
    public List<ScreenResolutionDto> findDistinctScreenResolutions() {
        List<List<Integer>> distinctScreenResolutions = phoneRepository.findDistinctScreenResolutions();
        return distinctScreenResolutions.stream().map(v -> new ScreenResolutionDto(v.get(0), v.get(1))).collect(Collectors.toList());
    }

    @Override
    public List<Integer> findDistinctScreenRefreshRates() {
        return phoneRepository.findDistinctScreenRefreshRates();
    }

    @Override
    public List<Float> findDistinctRamVariants() {
        return phoneRepository.findDistinctRamVariants();
    }

    @Override
    public List<Float> findDistinctRomVariants() {
        return phoneRepository.findDistinctRomVariants();
    }

    @Override
    public List<Integer> findDistinctCamerasAmountVariants() {
        return phoneRepository.findDistinctCamerasAmountVariants();
    }

    @Override
    public List<Float> findDistinctCamerasInMp() {
        return phoneRepository.findDistinctCamerasInMp();
    }

    @Override
    public List<Integer> findDistinctSimCardsAmountVariants() {
        return phoneRepository.findDistinctSimCardsAmountVariants();
    }

    @Override
    public List<Integer> findDistinctBatteryCapacities() {
        return phoneRepository.findDistinctBatteryCapacities();
    }

    @Override
    public List<Float> findDistinctFrontCameraVariants() {
        return phoneRepository.findDistinctFrontCameraVariants();
    }

    @Override
    public List<Float> findDistinctLengthVariants() {
        return phoneRepository.findDistinctLengthVariants();
    }

    @Override
    public List<Float> findDistinctWidthVariants() {
        return phoneRepository.findDistinctWidthVariants();
    }

    @Override
    public List<Float> findDistinctThicknessVariants() {
        return phoneRepository.findDistinctThicknessVariants();
    }

    @Override
    public List<Float> findDistinctWeightVariants() {
        return phoneRepository.findDistinctWeightVariants();
    }
}
