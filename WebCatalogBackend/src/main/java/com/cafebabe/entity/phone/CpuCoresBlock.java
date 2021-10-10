package com.cafebabe.entity.phone;

import com.cafebabe.entity.BaseDataObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CpuCoresBlock extends BaseDataObject {

    protected String name;
    protected Integer coresAmount;
    protected Integer clockSpeedInMHz;

    public CpuCoresBlock(String name, Integer coresAmount, Integer clockSpeedInMHz) {
        this.name = name;
        this.coresAmount = coresAmount;
        this.clockSpeedInMHz = clockSpeedInMHz;
    }
}
