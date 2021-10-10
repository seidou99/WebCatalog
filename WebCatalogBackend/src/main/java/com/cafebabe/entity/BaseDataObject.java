package com.cafebabe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigInteger;

@Getter
@Setter
@MappedSuperclass
public class BaseDataObject {

    @Id
    @GeneratedValue
    protected BigInteger id;


}
