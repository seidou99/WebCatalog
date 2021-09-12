package com.cafebabe.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class ScreenTechnology extends BaseDataObjectWithUniqueName {

    public ScreenTechnology(String name) {
        super(name);
    }
}
