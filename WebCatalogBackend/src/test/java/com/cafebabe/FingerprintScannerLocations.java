package com.cafebabe;

import com.cafebabe.entity.FingerprintScannerLocation;

import java.util.Arrays;
import java.util.List;

public interface FingerprintScannerLocations {

    FingerprintScannerLocation ON_THE_FRONT_PANEL = new FingerprintScannerLocation("На фронтальной панели"), ON_THE_BACK_PANEL = new FingerprintScannerLocation("На тыльной панели"), ON_THE_SIDE_END = new FingerprintScannerLocation("На боковом торце"), BUILT_INTO_THE_DISPLAY = new FingerprintScannerLocation("Встроен в дисплей");

    List<FingerprintScannerLocation> ALL = Arrays.asList(ON_THE_FRONT_PANEL, ON_THE_BACK_PANEL, ON_THE_SIDE_END, BUILT_INTO_THE_DISPLAY);
}
