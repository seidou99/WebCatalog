package com.cafebabe.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Color extends BaseDataObjectWithUniqueName {

    public Color(String name) {
        super(name);
    }
}
