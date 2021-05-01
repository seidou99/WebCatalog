package com.cafebabe.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenResolutionDto {

    protected int horizontal;
    protected int vertical;

    public ScreenResolutionDto(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
}
