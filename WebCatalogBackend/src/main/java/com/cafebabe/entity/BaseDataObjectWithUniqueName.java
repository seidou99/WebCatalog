package com.cafebabe.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class BaseDataObjectWithUniqueName extends BaseDataObject {

    @Column(unique = true)
    protected String name;

    public BaseDataObjectWithUniqueName(String name) {
        this.name = name;
    }
}
