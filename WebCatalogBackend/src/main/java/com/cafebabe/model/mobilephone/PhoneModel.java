package com.cafebabe.model.mobilephone;

import com.cafebabe.model.*;
import com.cafebabe.model.digital_technology_common.AspectRatio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class PhoneModel extends BaseDataObject {

    @ManyToOne
    protected Manufacturer manufacturer;

    protected int marketLaunchYear;

    @Enumerated(EnumType.STRING)
    protected MobilePhoneType mobilePhoneType;

    @ManyToOne
    protected OperationSystemWithVersion operationSystemWithVersion;

    protected Float screenDiagonalInInches;

    @OneToMany
    protected List<RamAndRomVariant> ramAndRomVariants;

    protected Integer horizontalScreenResolution;

    protected Integer verticalScreenResolution;

    @ManyToOne
    protected ScreenTechnology screenTechnology;

    protected Integer screenRefreshRate;

    @ManyToOne
    protected RamType ramType;

    @ManyToOne
    protected FingerprintScannerLocation fingerprintScannerLocation;

    @ManyToOne
    protected RomType romType;

    protected Integer simCardsAmount;

    @ManyToOne
    protected SimCardType simCardType;

    protected boolean isMemoryCardSupported;

    protected Integer camerasAmount;

    protected Integer cameraInMp;

    protected boolean is5GSupported;

    @ManyToOne
    protected PhoneCpu cpu;

//    @ManyToMany
//    protected List<MemoryCardType> supportedMemoryCardTypes;

//    protected Integer maxMemoryCardSizeInGb;

    protected boolean hasAudioProcessor;

    protected float frontCamera;

    protected boolean hasAudioOutput;

    @ManyToOne
    protected ConnectionSocket connectionSocket;

    protected int screenPpi;

    @ManyToOne
    protected AspectRatio aspectRatio;

    protected String bodyMaterial;

    protected Float length;

    protected Float width;

    protected Float thickness;

    protected Float weight;
}
