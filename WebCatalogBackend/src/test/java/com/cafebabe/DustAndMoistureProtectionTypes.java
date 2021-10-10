package com.cafebabe;

import com.cafebabe.entity.DustAndMoistureProtection;

import java.util.Arrays;
import java.util.List;

public interface DustAndMoistureProtectionTypes {

    DustAndMoistureProtection IPX2 = new DustAndMoistureProtection("IPX2"), IPX4 = new DustAndMoistureProtection("IPX4"), IP52 = new DustAndMoistureProtection("IP52"), IP53 = new DustAndMoistureProtection("IP53"), IP54 = new DustAndMoistureProtection("IP54"), IP64 = new DustAndMoistureProtection("IP64"), IP65 = new DustAndMoistureProtection("IP65"), IP67 = new DustAndMoistureProtection("IP67"), IPX8 = new DustAndMoistureProtection("IPX8"), IP68 = new DustAndMoistureProtection("IP68"), IP69K = new DustAndMoistureProtection("IP69K");

    List<DustAndMoistureProtection> ALL = Arrays.asList(IPX2, IPX4, IP52, IP53, IP54, IP64, IP65, IP67, IPX8, IP68, IP69K);
}
