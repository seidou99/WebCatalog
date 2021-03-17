package com.cafebabe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;

@Getter
@Setter
@Entity
public class CpuCoresBlock extends BaseDataObject{

    protected Integer coresAmount;
    protected Integer clockSpeedInMHz;
}
