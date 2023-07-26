package com.coletechie.productservice.service.serviceImpl;

import com.coletechie.productservice.dto.ProductRequest;
import com.coletechie.productservice.dto.ProductResponse;
import com.coletechie.productservice.model.Product;
import com.coletechie.productservice.service.ProductService;
import com.coletechie.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .id(UUID.randomUUID().toString().split("-")[0])
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
       productRepository.save(product);
       log.info("Product {} saved successfully", product.getId());
       return new ModelMapper().map(product, ProductResponse.class);
    }

    @Override
    public List<ProductResponse> availableProducts(){
        List<Product> allProducts = productRepository.findAll();
        List<ProductResponse> responseList = new ArrayList<>();
        for(Product p :allProducts) {
            responseList.add(new ModelMapper().map(p,ProductResponse.class));
        }
        return responseList;
    }
}
