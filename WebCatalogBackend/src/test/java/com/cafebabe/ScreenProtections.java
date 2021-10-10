package com.cafebabe;

import com.cafebabe.entity.ScreenProtection;

import java.util.Arrays;
import java.util.List;

public interface ScreenProtections {

        ScreenProtection GORILLA_GLASS_V1 = new ScreenProtection("Gorilla Glass v1"), GORILLA_GLASS_V2 = new ScreenProtection("Gorilla Glass v2"), GORILLA_GLASS_V3 = new ScreenProtection("Gorilla Glass v3"), GORILLA_GLASS_V3_PLUS = new ScreenProtection("Gorilla Glass v3+"), GORILLA_GLASS_V4 = new ScreenProtection("Gorilla Glass v4"), GORILLA_GLASS_V5 = new ScreenProtection("Gorilla Glass v5"), GORILLA_GLASS_V6 = new ScreenProtection("Gorilla Glass v6"), GORILLA_GLASS_VICTUS = new ScreenProtection("Gorilla Glass Victus"), JAPAN_AGC_GLASS = new ScreenProtection("Japan AGC glass"), DRAGONTRAIL = new ScreenProtection("Dragontrail"), DINOREX_GLASS = new ScreenProtection("Dinorex Glass"), PANDA_KING_GLASS = new ScreenProtection("Panda King Glass"), XENSATION_GLASS = new ScreenProtection("Xensation Glass"), CERAMIC_SHIELD = new ScreenProtection("Ceramic Shield");

        List<ScreenProtection> ALL = Arrays.asList(GORILLA_GLASS_V1, GORILLA_GLASS_V2, GORILLA_GLASS_V3, GORILLA_GLASS_V3_PLUS, GORILLA_GLASS_V4, GORILLA_GLASS_V5, GORILLA_GLASS_V6, GORILLA_GLASS_VICTUS, JAPAN_AGC_GLASS, DRAGONTRAIL, DINOREX_GLASS, PANDA_KING_GLASS, XENSATION_GLASS, CERAMIC_SHIELD);
}
