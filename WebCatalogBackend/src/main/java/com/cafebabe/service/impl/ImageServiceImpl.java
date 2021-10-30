package com.cafebabe.service.impl;

import com.cafebabe.entity.Image;
import com.cafebabe.repository.ImageRepository;
import com.cafebabe.service.interfaces.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ImageServiceImpl extends BaseDataObjectServiceImpl<ImageRepository, Image> implements ImageService {

    private static final String IMAGE_PREFIX = "image-";

    @Override
    public Image saveImage(MultipartFile imageFile) {
        return this.saveImages(Collections.singletonList(imageFile)).get(0);
    }

    protected String getImagesDirectory() {
        String currentDirectory = System.getProperty("user.dir");
        return currentDirectory + File.separator + "images";
    }

    @Override
    public List<Image> saveImages(List<MultipartFile> imageFiles) {
        List<Image> images = new ArrayList<>(imageFiles.size());
        for (MultipartFile imageFile : imageFiles) {
            String imagesDirectoryPath = getImagesDirectory();
            String fileExtension = getFileExtension(imageFile.getOriginalFilename());
            File tempFile = null;
            try {
                tempFile = File.createTempFile(IMAGE_PREFIX, "." + fileExtension, new File(imagesDirectoryPath));
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

    public void deleteImage(Image image) throws IOException {
        deleteImages(Collections.singletonList(image));
    }

    public void deleteImages(List<Image> images) throws IOException {
        String imagesDirectory = getImagesDirectory();
        for (Image image : images) {
            Path path = Paths.get(imagesDirectory + File.separator + image.getImageName());
            Files.deleteIfExists(path);
        }
        baseRepository.deleteAll(images);
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
