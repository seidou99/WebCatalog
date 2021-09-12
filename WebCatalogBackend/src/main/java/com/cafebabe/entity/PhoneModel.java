package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PhoneModel extends BaseDataObjectWithUniqueName {

    @ManyToOne
    protected Manufacturer manufacturer;

    protected int marketLaunchYear;

//    @Enumerated(EnumType.STRING)
//    protected MobilePhoneType mobilePhoneType;

    @ManyToOne(optional = false)
    protected OperationSystemWithVersion operationSystemWithVersion;

    @Column(nullable = false)
    protected float screenDiagonalInInches;

    @OneToMany
    @Column(nullable = false)
    protected List<RamAndRomVariant> ramAndRomVariants;

    @Column(nullable = false)
    protected int horizontalScreenResolution;

    @Column(nullable = false)
    protected int verticalScreenResolution;

    @ManyToOne(optional = false)
    protected ScreenTechnology screenTechnology;

    @Column(nullable = false)
    protected int screenRefreshRate;

//    @ManyToOne(optional = false)
//    protected RamType ramType;

    @ManyToOne(optional = false)
    protected FingerprintScannerLocation fingerprintScannerLocation;

//    @ManyToOne(optional = false)
//    protected RomType romType;

    @Column(nullable = false)
    protected int simCardsAmount;

    @ManyToOne(optional = false)
    protected SimCardType simCardType;

    @Column(nullable = false)
    protected boolean isMemoryCardSupported;

    @Column(nullable = false)
    protected int camerasAmount;

    @Column(nullable = false)
    protected int cameraInMp;

    @Column(nullable = false)
    protected boolean is5GSupported;

    @ManyToOne(optional = false)
    protected PhoneCpu cpu;

//    @ManyToMany
//    protected List<MemoryCardType> supportedMemoryCardTypes;

//    protected int maxMemoryCardSizeInGb;

    @Column(nullable = false)
    protected float frontCameraInMp;

    @Column(nullable = false)
    protected boolean hasAudioOutput;

    @ManyToOne(optional = false)
    protected ConnectionSocket connectionSocket;

    @Column(nullable = false)
    protected int screenPpi;

//    @ManyToOne
//    protected AspectRatio aspectRatio;

//    protected String bodyMaterial;

    @ManyToMany()
    @Column(nullable = false)
    protected List<Color> bodyColors;

    @ManyToOne()
//    @JoinColumn
    @JoinColumn(nullable = true)
    protected DustAndMoistureProtection dustAndMoistureProtection;

    @Column(nullable = false)
    protected float length;

    @Column(nullable = false)
    protected float width;

    @Column(nullable = false)
    protected float thickness;

    @Column(nullable = false)
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

    public PhoneModel(String name, Manufacturer manufacturer, int marketLaunchYear, OperationSystemWithVersion operationSystemWithVersion, float screenDiagonalInInches, List<RamAndRomVariant> ramAndRomVariants, int horizontalScreenResolution, int verticalScreenResolution, ScreenTechnology screenTechnology, int screenRefreshRate, FingerprintScannerLocation fingerprintScannerLocation, int simCardsAmount, SimCardType simCardType, boolean isMemoryCardSupported, int camerasAmount, int cameraInMp, boolean is5GSupported, PhoneCpu cpu, float frontCameraInMp, boolean hasAudioOutput, ConnectionSocket connectionSocket, List<Color> bodyColors, DustAndMoistureProtection dustAndMoistureProtection, float length, float width, float thickness, float weight, int batteryCapacity, ScreenProtection screenProtection, boolean hasNfc) {
        super(name);
        this.manufacturer = manufacturer;
        this.marketLaunchYear = marketLaunchYear;
        this.operationSystemWithVersion = operationSystemWithVersion;
        this.screenDiagonalInInches = screenDiagonalInInches;
        this.ramAndRomVariants = ramAndRomVariants;
        this.horizontalScreenResolution = horizontalScreenResolution;
        this.verticalScreenResolution = verticalScreenResolution;
        this.screenTechnology = screenTechnology;
        this.screenRefreshRate = screenRefreshRate;
        this.fingerprintScannerLocation = fingerprintScannerLocation;
        this.simCardsAmount = simCardsAmount;
        this.simCardType = simCardType;
        this.isMemoryCardSupported = isMemoryCardSupported;
        this.camerasAmount = camerasAmount;
        this.cameraInMp = cameraInMp;
        this.is5GSupported = is5GSupported;
        this.cpu = cpu;
        this.frontCameraInMp = frontCameraInMp;
        this.hasAudioOutput = hasAudioOutput;
        this.connectionSocket = connectionSocket;
        this.bodyColors = bodyColors;
        this.dustAndMoistureProtection = dustAndMoistureProtection;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
        this.screenProtection = screenProtection;
        this.hasNfc = hasNfc;
    }

    public PhoneModel(String name, Manufacturer manufacturer, int marketLaunchYear, OperationSystemWithVersion operationSystemWithVersion, float screenDiagonalInInches, List<RamAndRomVariant> ramAndRomVariants, int horizontalScreenResolution, int verticalScreenResolution, ScreenTechnology screenTechnology, int screenRefreshRate, FingerprintScannerLocation fingerprintScannerLocation, int simCardsAmount, SimCardType simCardType, boolean isMemoryCardSupported, int camerasAmount, int cameraInMp, boolean is5GSupported, PhoneCpu cpu, float frontCameraInMp, boolean hasAudioOutput, ConnectionSocket connectionSocket, List<Color> bodyColors, DustAndMoistureProtection dustAndMoistureProtection, float length, float width, float thickness, float weight, int batteryCapacity, ScreenProtection screenProtection, boolean hasNfc, List<Image> images, Image mainImage) {
        this(name, manufacturer, marketLaunchYear, operationSystemWithVersion, screenDiagonalInInches, ramAndRomVariants, horizontalScreenResolution, verticalScreenResolution, screenTechnology, screenRefreshRate, fingerprintScannerLocation, simCardsAmount, simCardType, isMemoryCardSupported, camerasAmount, cameraInMp, is5GSupported, cpu, frontCameraInMp, hasAudioOutput, connectionSocket, bodyColors, dustAndMoistureProtection, length, width, thickness, weight, batteryCapacity, screenProtection, hasNfc);
        this.images = images;
        this.mainImage = mainImage;
    }
}
