package com.vay.magaz.service;


import com.vay.magaz.database.entity.Product;
import com.vay.magaz.database.repository.ProductRepository;
import com.vay.magaz.dto.ProductDto;
import com.vay.magaz.factory.ProductDtoFactory;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductService {
    ProductRepository productRepository;
    ProductDtoFactory productDtoFactory;

    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id)
                .map(productDtoFactory::makeProjectDto);
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(productDtoFactory::makeProjectDto)
                .toList();
    }

    @Transactional
    public void create(Product product) {
        productRepository.saveAndFlush(Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .city(product.getCity())
                .build());
    }

    @Transactional
    public boolean deleteById(Long id) {
        return productRepository.findById(id).map(product -> {
                    productRepository.delete(product);
                    productRepository.flush();
                    return true;
                }).orElse(false);
    }
}
