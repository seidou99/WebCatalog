package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FingerprintScannerLocation extends BaseDataObjectWithUniqueName {

    public FingerprintScannerLocation(String name) {
        super(name);
    }
}
