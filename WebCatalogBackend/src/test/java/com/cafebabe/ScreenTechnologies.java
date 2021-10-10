package com.cafebabe;

import com.cafebabe.entity.ScreenTechnology;

import java.util.Arrays;
import java.util.List;

public interface ScreenTechnologies {
    ScreenTechnology IPS = new ScreenTechnology("IPS"), AMOLED = new ScreenTechnology("AMOLED"), OLED = new ScreenTechnology("OLED"), PVA_SLCD = new ScreenTechnology("PVA (SLCD)"), PLS = new ScreenTechnology("PLS");

    List<ScreenTechnology> ALL = Arrays.asList(IPS, AMOLED, OLED, PVA_SLCD, PLS);
}
