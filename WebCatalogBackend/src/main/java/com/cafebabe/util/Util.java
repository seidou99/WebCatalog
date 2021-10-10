package com.cafebabe.util;

import com.cafebabe.entity.phone.Phone;

import java.math.BigDecimal;

public class Util {

    public static int calculateScreenPpi(Phone phone) {
        double diagonalInPx = Math.sqrt(Math.pow(phone.getHorizontalScreenResolution(), 2) + Math.pow(phone.getVerticalScreenResolution(), 2));
        double ppi = Math.floor(diagonalInPx / phone.getScreenDiagonalInInches());
        return BigDecimal.valueOf(ppi).intValue();
    }
}
