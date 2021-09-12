package com.cafebabe.service.impl;

import com.cafebabe.dto.PhoneFilterDto;
import com.cafebabe.entity.*;
import com.cafebabe.entity.PhoneModel;
import com.cafebabe.repository.PhoneRepository;
import com.cafebabe.service.interfaces.PhoneModelService;
import com.cafebabe.service.interfaces.PhoneService;
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
    public Long findFilteredPhonesCount(PhoneFilterDto phoneFilterDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Phone> root = criteriaQuery.from(Phone.class);
        buildCriteriaQuery(root, phoneFilterDto, criteriaBuilder, criteriaQuery);
        CriteriaQuery<Long> select = criteriaQuery.select(criteriaBuilder.countDistinct(root));
        TypedQuery<Long> query = entityManager.createQuery(select);
        return query.getResultList().stream().count();
    }

    protected void buildCriteriaQuery(Root<Phone> phoneRoot, PhoneFilterDto phoneFilterDto, CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery) {
        Join<Phone, PhoneModel> phoneModelJoin = phoneRoot.join(Phone_.phoneModel);
        phoneModelService.buildCriteriaQuery(phoneModelJoin, phoneFilterDto, criteriaBuilder, criteriaQuery);
        filterBodyColors(phoneFilterDto.getBodyColors(), phoneRoot, criteriaQuery, criteriaBuilder);
        filterRamAndRomVariants(phoneRoot, phoneFilterDto.getRamVariants(), phoneFilterDto.getRomVariants(), criteriaBuilder, criteriaQuery);
    }

    protected void filterBodyColors(List<Color> bodyColors, Root<Phone> phoneRoot, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (!bodyColors.isEmpty()) {
            Join<Phone, Color> join = phoneRoot.join(Phone_.color);
            CriteriaBuilder.In<BigInteger> in = criteriaBuilder.in(join.get(Color_.id));
            bodyColors.forEach(color -> in.value(color.getId()));
            criteriaQuery.where(criteriaQuery.getRestriction(), in);
        }
    }

    protected void filterRamAndRomVariants(Root<Phone> phoneRoot, List<Integer> ramVariants, List<Integer> romVariants, CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery) {
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
