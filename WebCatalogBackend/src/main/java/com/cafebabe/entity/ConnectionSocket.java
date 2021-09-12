package com.cafebabe.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class ConnectionSocket extends BaseDataObjectWithUniqueName {

    public ConnectionSocket(String name) {
        super(name);
    }
}
