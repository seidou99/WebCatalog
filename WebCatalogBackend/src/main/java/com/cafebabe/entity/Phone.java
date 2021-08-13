package com.cafebabe.entity;

import com.cafebabe.entity.mobilephone.PhoneModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Phone extends BaseDataObjectWithName {

    @ManyToOne
    protected PhoneModel phoneModel;

    @ManyToOne
    protected Color color;

    @ManyToOne
    protected RamAndRomVariant ramAndRomVariant;
}
