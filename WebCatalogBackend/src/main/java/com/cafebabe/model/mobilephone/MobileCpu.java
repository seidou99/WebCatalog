package com.cafebabe.model.mobilephone;

import com.cafebabe.model.BaseDataObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class MobileCpu extends BaseDataObject {

    protected Integer clockSpeedImMHz;
    protected String cores;

    @ManyToMany
    protected List<MobileCpuMicroarchitecture> microarchitectureList;
    protected Integer SizeInBits;
    protected Integer techprocessInNm;

}
