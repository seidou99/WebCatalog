package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OperationSystemWithVersion extends BaseDataObject {

    protected String version;

    @ManyToOne
    protected OperationSystem operationSystem;

    public OperationSystemWithVersion(String version, OperationSystem operationSystem) {
        this.version = version;
        this.operationSystem = operationSystem;
    }
}
