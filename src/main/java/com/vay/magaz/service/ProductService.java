package com.vay.magaz.service;

import com.vay.magaz.store.entity.Product;
import com.vay.magaz.store.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductService {
    ProductRepository productRepository;


    @Transactional
    public void create(Product product) {
        productRepository.save(product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .city(product.getCity())
                .build());
    }

    @Transactional
    public boolean delete(Long id) {
        return productRepository.findById(id).map(product -> {
            productRepository.delete(product);
            productRepository.flush();
            return true;
        })
        .orElse(false);
    }
}
