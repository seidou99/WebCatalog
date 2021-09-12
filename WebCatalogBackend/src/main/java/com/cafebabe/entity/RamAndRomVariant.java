package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RamAndRomVariant extends BaseDataObject {

    protected int ramSizeInGb;
    protected int romSizeInGb;

    public RamAndRomVariant(int ramSizeInGb, int romSizeInGb) {
        this.ramSizeInGb = ramSizeInGb;
        this.romSizeInGb = romSizeInGb;
    }
}
