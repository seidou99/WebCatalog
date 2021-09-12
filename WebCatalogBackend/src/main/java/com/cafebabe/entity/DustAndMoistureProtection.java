package com.cafebabe.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class DustAndMoistureProtection extends BaseDataObjectWithUniqueName {

    public DustAndMoistureProtection(String name) {
        super(name);
    }
}
