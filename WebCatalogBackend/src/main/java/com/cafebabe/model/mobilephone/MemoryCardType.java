package com.cafebabe.model.mobilephone;

import com.cafebabe.model.BaseDataObject;

import javax.persistence.Entity;

@Entity
public class MemoryCardType extends BaseDataObject {

    public static String MICRO_SD = "MICRO_SD", MICRO_SD_HC = "MICRO_SD_HC", MICRO_SD_XC = "MICRO_SD_XC";
}
