package com.vay.magaz.database.repository;

import com.vay.magaz.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Stream<Product> streamAllByTitleStartsWithIgnoreCase(String title);

    Stream<Product> streamAllBy();
}
