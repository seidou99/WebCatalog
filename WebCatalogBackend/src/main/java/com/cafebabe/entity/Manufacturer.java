package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Manufacturer extends BaseDataObjectWithUniqueName {

    @ManyToMany
    protected List<ManufacturerType> manufacturerTypes;

    public Manufacturer(String name, List<ManufacturerType> manufacturerTypes) {
        super(name);
        this.manufacturerTypes = manufacturerTypes;
    }

    public Manufacturer(String name, ManufacturerType manufacturerType) {
        this(name, Collections.singletonList(manufacturerType));
    }
}
