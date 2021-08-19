package com.cafebabe.service.mobilephone.impl;

import com.cafebabe.dto.PhoneModelFilterDto;
import com.cafebabe.dto.ScreenResolutionDto;
import com.cafebabe.entity.PhoneGpu;
import com.cafebabe.entity.Manufacturer;
import com.cafebabe.entity.Manufacturer_;
import com.cafebabe.entity.mobilephone.PhoneModel;
import com.cafebabe.entity.mobilephone.PhoneModel_;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class PhoneModelServiceImplTest {

    @Autowired
    PhoneModelServiceImpl phoneModelService;

    @Autowired
    EntityManager entityManager;

    PhoneModelFilterDto filterDto;
    CriteriaBuilder criteriaBuilder;
    CriteriaQuery<PhoneModel> criteriaQuery;
    Root<PhoneModel> root;
    List<Predicate> predicates;

    @BeforeEach
    public void beforeEach() {
        filterDto = new PhoneModelFilterDto();
        criteriaBuilder = entityManager.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(PhoneModel.class);
        root = criteriaQuery.from(PhoneModel.class);
        predicates = new ArrayList<>();
    }

    @Test()
    @Disabled
    public void joinAndFilterTest() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(BigInteger.ONE);
//        manufacturer.setId(BigInteger.TEN);
        filterDto.setManufacturers(Collections.singletonList(manufacturer));
        phoneModelService.joinAndFilter(root, filterDto.getManufacturers(), predicates, PhoneModel_.MANUFACTURER, Manufacturer_.ID, criteriaBuilder);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        List<PhoneModel> resultList = query.getResultList();
        String s = "";
    }

    @Test
    @Disabled
    public void numberFilterTest() {
        filterDto.setMarketLaunchYears(Collections.singletonList(6666));
        phoneModelService.filter(root, filterDto.getMarketLaunchYears(), predicates, PhoneModel_.MARKET_LAUNCH_YEAR, criteriaBuilder);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        List<PhoneModel> resultList = query.getResultList();
        String s = "";
    }

    @Test
    @Disabled
    public void booleanFilterTest() {
        filterDto.setIsMemoryCardSupported(false);
        phoneModelService.filter(root, filterDto.getIsMemoryCardSupported(), predicates, PhoneModel_.IS_MEMORY_CARD_SUPPORTED, criteriaBuilder);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        List<PhoneModel> resultList = query.getResultList();
        String s = "";
    }

    @Test
    @Disabled
    public void testFilterScreenResolution() {
        ScreenResolutionDto resolution1 = new ScreenResolutionDto(666, 666);
        ScreenResolutionDto resolution2 = new ScreenResolutionDto(666, 777);
        ScreenResolutionDto resolution3 = new ScreenResolutionDto(555, 666);
        filterDto.setScreenResolutions(Arrays.asList(resolution1, resolution2, resolution3));
        phoneModelService.filterScreenResolution(filterDto, criteriaBuilder, root, predicates);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        List<PhoneModel> resultList = query.getResultList();
        String s = "";
    }

    @Test
    @Disabled
    public void filterRamAndRomVariantsTest() {
        filterDto.setRamVariants(Collections.singletonList(6));
        filterDto.setRomVariants(Collections.singletonList(4));
        phoneModelService.filterRamAndRomVariants(filterDto, criteriaBuilder, root, predicates);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        List<PhoneModel> resultList = query.getResultList();
        String s = "";
    }

    @Test
    @Disabled
    public void filterGpu() {
        PhoneGpu phoneGpu = new PhoneGpu();
        phoneGpu.setId(BigInteger.valueOf(11L));
        filterDto.setPhoneGpuVariants(Collections.singletonList(phoneGpu));
        phoneModelService.filterGpu(filterDto, criteriaBuilder, root, predicates);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        List<PhoneModel> resultList = query.getResultList();
        String s = "";
    }

    @Test
    @Disabled
    public void filterCpuTechprocess() {
        filterDto.setCpuTechprocessVariants(Collections.singletonList(7));
        phoneModelService.filterCpuTechprocess(filterDto, criteriaBuilder, root, predicates);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        List<PhoneModel> resultList = query.getResultList();
        String s = "";
    }

    @Test
    @Disabled
    public void filterCpuCoresAmount() {
        filterDto.setCoresAmountVariants(Collections.singletonList(7));
        phoneModelService.filterCpuCoresAmount(filterDto, criteriaBuilder, predicates, criteriaQuery);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        List<PhoneModel> resultList = query.getResultList();
        String s = "";
    }

    @Test
    @Disabled
    public void filterCpuClockSpeed() {
        filterDto.setCpuClockSpeedVariants(Collections.singletonList(1600));
        phoneModelService.filterCpuClockSpeed(filterDto, criteriaBuilder, predicates, criteriaQuery);
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<PhoneModel> query = entityManager.createQuery(criteriaQuery);
        List<PhoneModel> resultList = query.getResultList();
        String s = "";
    }
}
