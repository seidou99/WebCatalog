package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OperationSystemWithVersion {

    @Id
    @GeneratedValue
    protected BigInteger id;

    protected String version;

    @ManyToOne
    protected OperationSystem operationSystem;

    public OperationSystemWithVersion(String version, OperationSystem operationSystem) {
        this.version = version;
        this.operationSystem = operationSystem;
    }
}
