package com.cafebabe.util;

import com.cafebabe.entity.digital_technology_common.AspectRatio;
import com.cafebabe.entity.mobilephone.PhoneModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Util {

    public int calculateScreenPpi(PhoneModel phoneModel) {
        double diagonalInPx = Math.sqrt(Math.pow(phoneModel.getHorizontalScreenResolution(), 2) + Math.pow(phoneModel.getVerticalScreenResolution(), 2));
        double ppi = Math.floor(diagonalInPx / phoneModel.getScreenDiagonalInInches());
        return BigDecimal.valueOf(ppi).intValue();
    }

    public AspectRatio calculateScreenAspectRatio(PhoneModel phoneModel) {
        AspectRatio aspectRatio = new AspectRatio(null, phoneModel.getHorizontalScreenResolution(), phoneModel.getVerticalScreenResolution());
        for (int i = 2; i < Math.min(aspectRatio.getHorizontal(), aspectRatio.getVertical()); i++) {
            float horizontalMod = aspectRatio.getHorizontal() % i;
            float verticalMod = aspectRatio.getVertical() % i;
            if (verticalMod == 0.0f && horizontalMod == 0.0f) {
                aspectRatio.setHorizontal(aspectRatio.getHorizontal() / i);
                aspectRatio.setVertical(aspectRatio.getVertical() / i);
            }
        }
        return aspectRatio;
    }
}
