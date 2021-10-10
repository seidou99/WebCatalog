package com.cafebabe.entity.phone;

import com.cafebabe.entity.BaseDataObjectWithUniqueName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PhoneGpu extends BaseDataObjectWithUniqueName {

    protected Integer clockSpeedInMHz;

    public PhoneGpu(String name, Integer clockSpeedInMHz) {
        super(name);
        this.clockSpeedInMHz = clockSpeedInMHz;
    }

    public PhoneGpu(String name) {
        super(name);
    }
}
