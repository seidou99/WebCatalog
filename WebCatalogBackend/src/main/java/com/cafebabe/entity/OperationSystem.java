package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class OperationSystem extends BaseDataObjectWithUniqueName {

    @Enumerated
    protected OperationSystemType type;

    public OperationSystem(String name, OperationSystemType type) {
        super(name);
        this.type = type;
    }
}
