package com.cafebabe.model.digital_technology_common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AspectRatio {

    @Id
    @GeneratedValue
    protected BigInteger id;

    protected float horizontal;
    protected float vertical;
}
