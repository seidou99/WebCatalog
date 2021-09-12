package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PhoneCpu extends BaseDataObjectWithUniqueName {

    protected int clockSpeedImMHz;
    @ManyToOne
    protected PhoneGpu integratedGpu;

    @ManyToMany(fetch = FetchType.EAGER)
    protected List<CpuCoresBlock> coresBlocks;

    protected int digitalCapacityInBits;
    protected int techprocessInNm;

    public PhoneCpu(String name, PhoneGpu integratedGpu, List<CpuCoresBlock> coresBlocks, int digitalCapacityInBits, int techprocessInNm) {
        super(name);
        this.integratedGpu = integratedGpu;
        this.coresBlocks = coresBlocks;
        this.digitalCapacityInBits = digitalCapacityInBits;
        this.techprocessInNm = techprocessInNm;
    }
}
