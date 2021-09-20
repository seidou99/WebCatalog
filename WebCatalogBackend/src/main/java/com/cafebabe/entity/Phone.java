package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Phone extends ShopItem {

    @Column(unique = true)
    protected String name;

    @ManyToOne(optional = false)
    protected Color color;

    @Column(nullable = false, scale = 1)
    protected float ramSizeInGb;

    @Column(nullable = false, scale = 1)
    protected float romSizeInGb;

    @ManyToOne
    protected Manufacturer manufacturer;

    @Column(nullable = false)
    protected int marketLaunchYear;

    @ManyToOne(optional = false)
    protected OperationSystemWithVersion operationSystemWithVersion;

    @Column(nullable = false, scale = 2)
    protected float screenDiagonalInInches;

    @Column(nullable = false)
    protected int horizontalScreenResolution;

    @Column(nullable = false)
    protected int verticalScreenResolution;

    @ManyToOne(optional = false)
    protected ScreenTechnology screenTechnology;

    @Column(nullable = false)
    protected int screenRefreshRate;

    @ManyToOne(optional = false)
    protected FingerprintScannerLocation fingerprintScannerLocation;

    @Column(nullable = false)
    protected int simCardsAmount;

    @ManyToOne(optional = false)
    protected SimCardType simCardType;

    @Column(nullable = false)
    protected boolean isMemoryCardSupported;

    @Column(nullable = false)
    protected int camerasAmount;

    @Column(nullable = false, scale = 2)
    protected float cameraInMp;

    @Column(nullable = false)
    protected boolean is5GSupported;

    @ManyToOne(optional = false)
    protected PhoneCpu cpu;

//    @ManyToMany
//    protected List<MemoryCardType> supportedMemoryCardTypes;

//    protected int maxMemoryCardSizeInGb;

    @Column(nullable = false, scale = 2)
    protected float frontCameraInMp;

    @Column(nullable = false)
    protected boolean hasAudioOutput;

    @ManyToOne(optional = false)
    protected ConnectionSocket connectionSocket;

    @Column(nullable = false)
    protected int screenPpi;

    @ManyToOne(optional = false)
    protected Color bodyColor;

    @ManyToOne
//    @JoinColumn
    @JoinColumn
    protected DustAndMoistureProtection dustAndMoistureProtection;

    @Column(nullable = false, scale = 2)
    protected float length;

    @Column(nullable = false, scale = 2)
    protected float width;

    @Column(nullable = false, scale = 2)
    protected float thickness;

    @Column(nullable = false, scale = 2)
    protected float weight;

    @Column(nullable = false)
    protected int batteryCapacity;

    @ManyToOne
    protected ScreenProtection screenProtection;

    @Column(nullable = false)
    protected boolean hasNfc;

    @OneToMany
    protected List<Image> images;

    @OneToOne
    protected Image mainImage;
}
