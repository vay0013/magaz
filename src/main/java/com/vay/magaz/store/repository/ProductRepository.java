package com.vay.magaz.store.repository;

import com.vay.magaz.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Stream<Product> streamAllByTitleStartsWithIgnoreCase(String title);
}
