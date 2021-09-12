package com.cafebabe.entity;

import javax.persistence.Entity;

@Entity
public class MemoryCardType extends BaseDataObjectWithUniqueName {

    public static String MICRO_SD = "MICRO_SD", MICRO_SD_HC = "MICRO_SD_HC", MICRO_SD_XC = "MICRO_SD_XC";
}
