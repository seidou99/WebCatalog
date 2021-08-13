package com.cafebabe.entity.mobilephone;

import com.cafebabe.entity.BaseDataObjectWithName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class MobilePhoneCamera extends BaseDataObjectWithName {

    protected Integer cameraMegapixelsAmount;
}
