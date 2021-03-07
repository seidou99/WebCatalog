package com.cafebabe.model.mobilephone;

import com.cafebabe.model.BaseDataObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
public class OperationSystem extends BaseDataObject {

    @Enumerated
    protected OperationSystemType type;
}
