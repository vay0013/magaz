package com.vay.magaz.service;

import com.vay.magaz.database.entity.Product;
import com.vay.magaz.database.repository.ProductRepository;
import com.vay.magaz.dto.ProductDto;
import com.vay.magaz.factory.ProductDtoFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    public static final Long PRODUCT_ID = 1L;

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductDtoFactory productDtoFactory;

    @Test
    void findById(Long id) {
        doReturn(Optional.of(new Product(PRODUCT_ID)))
                .when(productRepository).findById(PRODUCT_ID);
    }

//    @Test
//    void findAll() {
//    }
//
//    @Test
//    void create() {
//    }
//
//    @Test
//    void deleteById() {
//    }
}