package com.cafebabe.model.mobilephone;

import com.cafebabe.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class MobilePhoneModel extends BaseDataObject {

    @ManyToOne
    protected Manufacturer manufacturer;

    protected Date marketLaunchDate;

    @Enumerated(EnumType.STRING)
    protected MobilePhoneType mobilePhoneType;

    @ManyToOne
    protected OperationSystemWithVersion operationSystem;

    protected Float screenDiagonalInInches;

    protected Integer horizontalScreenResolution;

    protected Integer verticalScreenResolution;

    @ManyToOne
    protected ScreenTechnology screenTechnology;

    protected Integer screenRefreshRate;

    protected Integer ramSizeInGb;

    @ManyToOne
    protected RamType ramType;

    @ManyToOne
    protected FingerprintScannerLocation fingerprintScannerLocation;

    protected Integer romSizeInGb;

    @ManyToOne
    protected RomType romType;

//    @OneToMany
//    protected List<MobilePhoneCamera> cameras;

    protected Integer simCardsAmount;

    @ManyToOne
    protected SimCardType simCardType;

    protected boolean isMemoryCardSupported;

    protected Integer camerasAmount;

    protected Integer cameraInMp;

    protected boolean is5GSupported;

    @ManyToMany
    protected List<MemoryCardType> supportedMemoryCardTypes;

    protected Integer maxMemoryCardSizeInGb;

    protected String bodyMaterial;

    protected Float length;

    protected Float width;

    protected Float thickness;
}
