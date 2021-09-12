package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ManufacturerType extends BaseDataObjectWithUniqueName {

    public ManufacturerType(String name) {
        super(name);
    }
}
