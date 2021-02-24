package com.cafebabe.model.mobilephone;

import com.cafebabe.model.BaseDataObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class MobilePhoneCamera extends BaseDataObject {

    protected Integer cameraMegapixelsAmount;
}
