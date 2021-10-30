package com.cafebabe.entity.phone;

import com.cafebabe.entity.*;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(nullable = false, scale = 1, name = "ram_size_in_gb")
    protected float ramSizeInGB;

    @Column(nullable = false, scale = 1, name = "rom_size_in_gb")
    protected float romSizeInGB;

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

    @ManyToOne
    protected FingerprintScannerLocation fingerprintScannerLocation;

    @Column(nullable = false)
    protected int simCardsAmount;

    @ManyToOne(optional = false)
    protected SimCardType simCardType;

    @Column(nullable = false)
    @JsonProperty("isMemoryCardSupported")
    protected boolean isMemoryCardSupported;

    @Column(nullable = false)
    protected int camerasAmount;

    @Column(nullable = false, scale = 2)
    protected float cameraInMp;

    @Column(nullable = false)
    @JsonProperty("is5GSupported")
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

    @OneToOne(optional = false)
    protected Image mainImage;

    public Phone(String name, float ramSizeInGB, float romSizeInGB, Manufacturer manufacturer, int marketLaunchYear, OperationSystemWithVersion operationSystemWithVersion, float screenDiagonalInInches, int horizontalScreenResolution, int verticalScreenResolution, ScreenTechnology screenTechnology, int screenRefreshRate, FingerprintScannerLocation fingerprintScannerLocation, int simCardsAmount, SimCardType simCardType, boolean isMemoryCardSupported, int camerasAmount, float cameraInMp, boolean is5GSupported, PhoneCpu cpu, float frontCameraInMp, boolean hasAudioOutput, ConnectionSocket connectionSocket, Color bodyColor, DustAndMoistureProtection dustAndMoistureProtection, float length, float width, float thickness, float weight, int batteryCapacity, ScreenProtection screenProtection, boolean hasNfc) {
        this.name = name;
        this.ramSizeInGB = ramSizeInGB;
        this.romSizeInGB = romSizeInGB;
        this.manufacturer = manufacturer;
        this.marketLaunchYear = marketLaunchYear;
        this.operationSystemWithVersion = operationSystemWithVersion;
        this.screenDiagonalInInches = screenDiagonalInInches;
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
        this.bodyColor = bodyColor;
        this.dustAndMoistureProtection = dustAndMoistureProtection;
        this.length = length;
        this.width = width;
        this.thickness = thickness;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
        this.screenProtection = screenProtection;
        this.hasNfc = hasNfc;
    }


}
