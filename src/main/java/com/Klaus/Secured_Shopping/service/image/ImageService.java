package com.Klaus.Secured_Shopping.service.image;

import com.Klaus.Secured_Shopping.dto.ImageDto;
import com.Klaus.Secured_Shopping.exceptions.ResourceNotFoundException;
import com.Klaus.Secured_Shopping.model.Image;
import com.Klaus.Secured_Shopping.model.Product;
import com.Klaus.Secured_Shopping.repository.ImageRepository;
import com.Klaus.Secured_Shopping.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements IImageService{
    private final ImageRepository imageRepository;
    private final IProductService productService;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not found Image with id: "+ id));
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse(imageRepository::delete, ()->{
            throw new ResourceNotFoundException("Not image with id: "+ id);
        });

    }

    @Override
    public Image saveImage(List<MultipartFile> files, Long productId) {
        Product product = productService.getProductById(productId);
        List<ImageDto>imageDtos = new ArrayList<>();

        for(MultipartFile file :files){
            try{
                Image image = new Image();
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setImage(new SerialBlob(file.getBytes()));
                image.setProduct(product);


                String downloadUrl = "/api/v1/iamges/image/download/"+image.getId();
                image.setDownloadUrl(downloadUrl);
                imageRepository.save(image);
            }catch (){

            }
        }
    }

    @Override
    public void updateImage(MultipartFile file, Long imageId) {
        Image image = getImageById(imageId);
        try {
            image.setFileName(file.getOriginalFilename());
            image.setFileName(file.getOriginalFilename());
            image.setImage(new SerialBlob(file.getBytes()));
            imageRepository.save(image);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
