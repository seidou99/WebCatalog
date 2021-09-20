package com.cafebabe.service.impl;

import com.cafebabe.entity.Manufacturer;
import com.cafebabe.entity.ManufacturerType;
import com.cafebabe.entity.ManufacturerType_;
import com.cafebabe.entity.Manufacturer_;
import com.cafebabe.repository.ManufacturerRepository;
import com.cafebabe.repository.ManufacturerTypeRepository;
import com.cafebabe.service.interfaces.ManufacturerService;
import com.cafebabe.service.interfaces.ManufacturerTypeService;
import org.hibernate.query.criteria.internal.path.ListAttributeJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManufacturerServiceImpl extends BaseDataObjectWithUniqueNameServiceImpl<ManufacturerRepository, Manufacturer> implements ManufacturerService {

    @Autowired
    protected ManufacturerTypeService manufacturerTypeService;

    @Autowired
    protected ManufacturerTypeRepository manufacturerTypeRepository;

    @Autowired
    protected EntityManager entityManager;

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        List<String> manufacturerTypesNames = manufacturer.getManufacturerTypes().stream().map(ManufacturerType::getName).collect(Collectors.toList());
        List<ManufacturerType> manufacturerTypes = manufacturerTypeRepository.findAllByNameIn(manufacturerTypesNames);
        manufacturer.setManufacturerTypes(manufacturerTypes);
        return baseRepository.save(manufacturer);
    }

    @Override
    public List<Manufacturer> findAllManufacturersWithType(String type) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Manufacturer> query = criteriaBuilder.createQuery(Manufacturer.class);
        Root<Manufacturer> root = query.from(Manufacturer.class);
        ListAttributeJoin<Manufacturer, ManufacturerType> fetch = (ListAttributeJoin<Manufacturer, ManufacturerType>) root.fetch(Manufacturer_.manufacturerTypes, JoinType.INNER);
        Predicate manufacturerTypeNameEqualPredicate = criteriaBuilder.equal(fetch.get(ManufacturerType_.name), type);
        query.where(manufacturerTypeNameEqualPredicate);
        List<Manufacturer> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }
}
