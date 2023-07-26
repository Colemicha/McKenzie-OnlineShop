package com.coletechie.productservice.service;

import com.coletechie.productservice.dto.ProductRequest;
import com.coletechie.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> availableProducts();
}
