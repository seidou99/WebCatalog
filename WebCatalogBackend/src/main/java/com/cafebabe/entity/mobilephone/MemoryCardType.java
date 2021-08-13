package com.cafebabe.entity.mobilephone;

import com.cafebabe.entity.BaseDataObjectWithName;

import javax.persistence.Entity;

@Entity
public class MemoryCardType extends BaseDataObjectWithName {

    public static String MICRO_SD = "MICRO_SD", MICRO_SD_HC = "MICRO_SD_HC", MICRO_SD_XC = "MICRO_SD_XC";
}
