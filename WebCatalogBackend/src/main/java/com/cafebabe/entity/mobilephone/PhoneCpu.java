package com.cafebabe.entity.mobilephone;

import com.cafebabe.entity.BaseDataObject;
import com.cafebabe.entity.CpuCoresBlock;
import com.cafebabe.entity.Gpu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.List;

@Getter
@Setter
@Entity
public class PhoneCpu extends BaseDataObject {

    protected int clockSpeedImMHz;
    @ManyToOne
    protected Gpu integratedGpu;

    @ManyToMany
    protected List<CpuCoresBlock> coresBlocks;

    protected int digitalCapacityInBits;
    protected int techprocessInNm;

}
