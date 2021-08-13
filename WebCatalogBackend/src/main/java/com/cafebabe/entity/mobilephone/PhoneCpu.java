package com.cafebabe.entity.mobilephone;

import com.cafebabe.entity.BaseDataObjectWithName;
import com.cafebabe.entity.CpuCoresBlock;
import com.cafebabe.entity.PhoneGpu;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class PhoneCpu extends BaseDataObjectWithName {

    protected int clockSpeedImMHz;
    @ManyToOne
    protected PhoneGpu integratedGpu;

    @ManyToMany(fetch = FetchType.EAGER)
    protected List<CpuCoresBlock> coresBlocks;

    protected int digitalCapacityInBits;
    protected int techprocessInNm;

}
