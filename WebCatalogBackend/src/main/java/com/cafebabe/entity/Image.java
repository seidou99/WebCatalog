package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Image extends BaseDataObject {

    protected String imageName;
    @Deprecated
    protected String imageRelativeDirectoryPath;

    public Image(String imageName) {
        this.imageName = imageName;
    }
}
