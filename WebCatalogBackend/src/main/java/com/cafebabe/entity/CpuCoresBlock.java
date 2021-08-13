package com.cafebabe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class CpuCoresBlock extends BaseDataObjectWithName {

    protected Integer coresAmount;
    protected Integer clockSpeedInMHz;
}
