package com.cafebabe.service.interfaces;

import com.cafebabe.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService extends BaseDataObjectService<Image> {

    List<Image> saveImages(List<MultipartFile> imageFiles) throws IOException;
}
