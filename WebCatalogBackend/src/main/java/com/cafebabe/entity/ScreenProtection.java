package com.cafebabe.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class ScreenProtection extends BaseDataObjectWithUniqueName {

    public ScreenProtection(String name) {
        super(name);
    }
}
