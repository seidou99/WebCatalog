package com.cafebabe.model.mobilephone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Getter
@Setter
@Entity
public class MobilePhoneOperationSystemWithVersion {

    @Id
    @GeneratedValue
    protected BigInteger id;

    protected Integer version;

    @ManyToOne
    protected MobilePhoneOperationSystem mobilePhoneOperationSystem;
}
