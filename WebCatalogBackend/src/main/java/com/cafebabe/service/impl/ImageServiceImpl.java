package com.cafebabe.service.impl;

import com.cafebabe.entity.Image;
import com.cafebabe.repository.ImageRepository;
import com.cafebabe.service.interfaces.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl extends BaseDataObjectServiceImpl<ImageRepository, Image> implements ImageService {

    @Override
    public List<Image> saveImages(List<MultipartFile> imageFiles) {
        List<Image> images = new ArrayList<>(imageFiles.size());
        for (MultipartFile imageFile : imageFiles) {
            String currentDirectory = System.getProperty("user.dir");
            String imagesDirectoryPath = currentDirectory + File.separator + "images";
            String fileExtension = getFileExtension(imageFile.getOriginalFilename());
            //TODO save file to fs
            File tempFile = null;
            try {
                tempFile = File.createTempFile("image-", "." + fileExtension, new File(imagesDirectoryPath));
                try (FileOutputStream fileOutputStream = new FileOutputStream(tempFile)) {
                    fileOutputStream.write(imageFile.getBytes());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Image image = new Image(tempFile.getName());
            baseRepository.save(image);
            images.add(image);
        }
        return images;
    }

    protected String getFileExtension(String fileName) {
        String result = "";
        int index = fileName.lastIndexOf('.');
        if (index != -1) {
            result = fileName.substring(index + 1);
        }
        return result;
    }
}
