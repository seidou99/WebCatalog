package com.cafebabe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
public class BaseDataObject {

    @Id
    @GeneratedValue
    protected BigInteger id;

    protected String name;
}
