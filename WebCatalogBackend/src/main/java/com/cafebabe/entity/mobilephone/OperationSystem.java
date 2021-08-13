package com.cafebabe.entity.mobilephone;

import com.cafebabe.entity.BaseDataObjectWithName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
public class OperationSystem extends BaseDataObjectWithName {

    @Enumerated
    protected OperationSystemType type;
}
