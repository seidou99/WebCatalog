package com.cafebabe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class RamAndRomVariant extends BaseDataObjectWithName {

    protected int ramSizeInGb;
    protected int romSizeInGb;
}
