package com.cafebabe.entity.mobilephone;

import com.cafebabe.entity.BaseDataObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class MobilePhoneCamera extends BaseDataObject {

    protected Integer cameraMegapixelsAmount;
}
