package com.cafebabe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class MobilePhoneCamera extends BaseDataObjectWithUniqueName {

    protected Integer cameraMegapixelsAmount;
}
