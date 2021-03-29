package com.cafebabe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class RamAndRomVariant extends BaseDataObject {

    protected int ramSizeInGb;
    protected int romSizeInGb;
}
