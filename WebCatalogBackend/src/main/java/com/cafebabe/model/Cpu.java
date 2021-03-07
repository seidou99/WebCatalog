package com.cafebabe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@Entity
public class Cpu extends BaseDataObject {

    protected Integer clockSpeedImMHz;
    protected String cores;
    @ManyToOne
    protected Gpu integratedGpu;

    @ManyToMany
    protected List<CpuMicroarchitecture> microarchitectureList;
    protected Integer digitalCapacityInBits;
    protected Integer techprocessInNm;

}
