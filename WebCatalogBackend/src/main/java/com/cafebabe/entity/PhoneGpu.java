package com.cafebabe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class PhoneGpu extends BaseDataObjectWithName {

    protected Integer clockSpeedInMHz;
}
