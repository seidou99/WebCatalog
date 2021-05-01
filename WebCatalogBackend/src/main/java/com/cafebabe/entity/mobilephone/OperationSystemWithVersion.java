package com.cafebabe.entity.mobilephone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Entity
@Getter
@Setter
public class OperationSystemWithVersion {

    @Id
    @GeneratedValue
    protected BigInteger id;

    protected String version;

    @ManyToOne
    protected OperationSystem operationSystem;
}
