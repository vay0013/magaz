package com.vay.magaz.service;

import com.vay.magaz.dto.ProductDto;
import com.vay.magaz.store.entity.Product;
import com.vay.magaz.store.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductService {
    ProductRepository productRepository;

    @Transactional
    public Optional<ProductDto> create(Product product) {
        return Builder.bild
    }
}
