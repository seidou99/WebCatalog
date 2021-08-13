package com.cafebabe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class BaseDataObjectWithName extends BaseDataObject {

    protected String name;
}
