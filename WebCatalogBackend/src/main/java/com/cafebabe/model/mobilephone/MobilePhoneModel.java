package com.cafebabe.model.mobilephone;

import com.cafebabe.model.BaseDataObject;
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
    protected MobilePhoneManufacturer manufacturer;

    protected Date marketLaunchDate;

    protected MobilePhoneType mobilePhoneType;

    @ManyToOne
    protected MobilePhoneOperationSystemWithVersion operationSystem;

    protected Float screenDiagonalInInches;

    protected Integer horizontalScreenResolution;

    protected Integer verticalScreenResolution;

    protected Integer ramSizeInGb;

    @ManyToOne
    protected RamType ramType;

    protected Integer romSizeInGb;

    @ManyToOne
    protected RomType romType;

    @OneToMany
    protected List<MobilePhoneCamera> cameras;

    protected Integer simCardsNumber;

    @ManyToMany
    protected List<MemoryCardType> supportedMemoryCardTypes;

    protected Integer maxMemoryCardSizeInGb;

    protected String bodyMaterial;

    protected Float length;

    protected Float width;

    protected Float thickness;
}
