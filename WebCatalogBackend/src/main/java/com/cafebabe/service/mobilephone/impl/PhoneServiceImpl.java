package com.cafebabe.service.mobilephone.impl;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.entity.*;
import com.cafebabe.entity.mobilephone.PhoneModel;
import com.cafebabe.repository.mobilephone.PhoneRepository;
import com.cafebabe.service.impl.BaseDataObjectServiceImpl;
import com.cafebabe.service.mobilephone.interfaces.PhoneModelService;
import com.cafebabe.service.mobilephone.interfaces.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.math.BigInteger;
import java.util.List;

@Service
public class PhoneServiceImpl extends BaseDataObjectServiceImpl<PhoneRepository, Phone> implements PhoneService {

    @Autowired
    protected EntityManager entityManager;

    @Autowired
    protected PhoneModelService phoneModelService;

    @Override
    public List<Phone> findFilteredPhoneModels(PhoneFilterDto filterDto, int pageIndex, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> criteriaQuery = criteriaBuilder.createQuery(Phone.class);
        Root<Phone> phoneRoot = criteriaQuery.from(Phone.class);
        Join<Phone, PhoneModel> phoneModelJoin = phoneRoot.join(Phone_.phoneModel);
        phoneModelService.buildCriteriaQuery(phoneModelJoin, filterDto, criteriaBuilder, criteriaQuery);
        filterBodyColors(filterDto.getBodyColors(), phoneRoot, criteriaQuery, criteriaBuilder);
        filterRamAndRomVariants(phoneRoot, filterDto.getRamVariants(), filterDto.getRomVariants(), criteriaBuilder, criteriaQuery);
        TypedQuery<Phone> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(pageIndex * pageSize);
        query.setMaxResults(pageSize);
        List<Phone> resultList = query.getResultList();
        return resultList;
    }

    protected void filterBodyColors(List<Color> bodyColors, Root<Phone> phoneRoot, CriteriaQuery<Phone> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (!bodyColors.isEmpty()) {
            Join<Phone, Color> join = phoneRoot.join(Phone_.color);
            CriteriaBuilder.In<BigInteger> in = criteriaBuilder.in(join.get(Color_.id));
            bodyColors.forEach(color -> in.value(color.getId()));
            criteriaQuery.where(criteriaQuery.getRestriction(), in);
        }
    }

    protected void filterRamAndRomVariants(Root<Phone> phoneRoot, List<Integer> ramVariants, List<Integer> romVariants, CriteriaBuilder criteriaBuilder, CriteriaQuery<Phone> criteriaQuery) {
        Join<Phone, RamAndRomVariant> ramAndRomVariantJoin = phoneRoot.join(Phone_.ramAndRomVariant);
        if (ramVariants.size() != 0) {
            CriteriaBuilder.In<Integer> ramSizePredicate = criteriaBuilder.in(ramAndRomVariantJoin.get(RamAndRomVariant_.ramSizeInGb));
            ramVariants.forEach(ramSizePredicate::value);
            criteriaQuery.where(criteriaQuery.getRestriction(), ramSizePredicate);
        }
        if (romVariants.size() != 0) {
            CriteriaBuilder.In<Integer> romSizePredicate = criteriaBuilder.in(ramAndRomVariantJoin.get(RamAndRomVariant_.ROM_SIZE_IN_GB));
            romVariants.forEach(romSizePredicate::value);
            criteriaQuery.where(criteriaQuery.getRestriction(), romSizePredicate);
        }
    }
}
