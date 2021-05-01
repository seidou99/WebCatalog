package com.cafebabe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class Manufacturer extends BaseDataObject {

    @Enumerated(EnumType.STRING)
    protected ManufacturerType manufacturerType;
}
