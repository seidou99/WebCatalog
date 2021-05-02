package com.cafebabe.entity.mobilephone;

import com.cafebabe.entity.*;
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

    protected float frontCameraInMp;

    protected boolean hasAudioOutput;

    @ManyToOne
    protected ConnectionSocket connectionSocket;

    protected int screenPpi;

//    @ManyToOne
//    protected AspectRatio aspectRatio;

    protected String bodyMaterial;

    @ManyToMany
    protected List<Color> bodyColors;

    @ManyToOne
    protected DustAndMoistureProtection dustAndMoistureProtection;

    protected Float length;

    protected Float width;

    protected Float thickness;

    protected Float weight;

    protected int batteryCapacity;

    @ManyToOne
    protected ScreenProtection screenProtection;
}
