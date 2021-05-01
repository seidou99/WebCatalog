package com.cafebabe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class CpuCoresBlock extends BaseDataObject{

    protected Integer coresAmount;
    protected Integer clockSpeedInMHz;
}
