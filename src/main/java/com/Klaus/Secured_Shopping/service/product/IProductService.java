package com.Klaus.Secured_Shopping.service.product;

import com.Klaus.Secured_Shopping.model.Product;
import com.Klaus.Secured_Shopping.request.AddProductRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest request);

    Product getProductById(Long id);
    void deleteProductById(Long id);
    void updateProduct(Product product,Long productId);

    List<Product> getAllProducts();
    List<Product>getProductsByCategory(String categoryId);
    List<Product>getProductsByBrand(String brand);
    List<Product>getProductsByCategoryAndBrand(String category, String brand);
    List<Product>getProductsByName(String name);
    List<Product> getProductsByBrandByName(String brand,String name);
    Long countProductByBrandAndName(String brand, String name);

}
