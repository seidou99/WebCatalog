package com.cafebabe.model;

import com.cafebabe.model.BaseDataObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class CpuMicroarchitecture extends BaseDataObject {

    protected Integer clockSpeedInMHz;
}
