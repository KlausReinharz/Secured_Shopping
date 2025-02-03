package com.Klaus.Secured_Shopping.service.image;

import com.Klaus.Secured_Shopping.dto.ImageDto;
import com.Klaus.Secured_Shopping.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {

    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto>saveImages(List<MultipartFile> file, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
