package com.cafebabe.model.mobilephone;

import com.cafebabe.model.BaseDataObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class MobileApuPlatform extends BaseDataObject {

    @OneToOne
    protected MobileCpu mobileCpu;

    @OneToOne
    protected MobileGpu mobileGpu;
}
