package com.Klaus.Secured_Shopping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;

    @Lob
    private Blob image;
    private String downloadUrl;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Image(String fileName, String fileType, Blob image, String downloadUrl) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.image = image;
        this.downloadUrl = downloadUrl;
    }
}
