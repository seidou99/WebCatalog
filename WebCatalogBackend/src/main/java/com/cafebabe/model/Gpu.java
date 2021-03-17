package com.cafebabe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Gpu extends BaseDataObject {

    protected boolean isIntegrated;
    protected GpuType gpuType;
    protected Integer streamingProcessorsAmount;
    protected Integer clockSpeedInMHz;
}
