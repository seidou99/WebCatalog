package com.cafebabe.model.mobilephone;

import com.cafebabe.model.BaseDataObject;
import com.cafebabe.model.Cpu;
import com.cafebabe.model.Gpu;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class MobileApuPlatform extends BaseDataObject {

    @OneToOne
    protected Cpu mobileCpu;

    @OneToOne
    protected Gpu mobileGpu;
}
