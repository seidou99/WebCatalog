package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Phone extends ShopItem {

    @Column(unique = true)
    protected String name;

    @ManyToOne(optional = false)
    protected PhoneModel phoneModel;

    @ManyToOne(optional = false)
    protected Color color;

    @ManyToOne(optional = false)
    protected RamAndRomVariant ramAndRomVariant;

    public Phone(String name, PhoneModel phoneModel, Color color, RamAndRomVariant ramAndRomVariant) {
        this.name = name;
        this.phoneModel = phoneModel;
        this.color = color;
        this.ramAndRomVariant = ramAndRomVariant;
    }
}
