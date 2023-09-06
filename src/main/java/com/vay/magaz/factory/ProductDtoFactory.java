package com.vay.magaz.factory;

import com.vay.magaz.database.entity.Product;
import com.vay.magaz.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoFactory {
    public ProductDto makeProjectDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .city(product.getCity())
                .price(product.getPrice())
                .build();
    }
}