package com.cafebabe.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PhoneFilterDto extends PhoneModelFilterDto {

    protected BigDecimal minPrice, maxPrice;
}
