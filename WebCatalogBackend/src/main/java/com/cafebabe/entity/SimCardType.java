package com.cafebabe.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class SimCardType extends BaseDataObjectWithUniqueName {

    public SimCardType(String name) {
        super(name);
    }
}
