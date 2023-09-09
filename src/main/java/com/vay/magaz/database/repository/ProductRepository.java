package com.vay.magaz.database.repository;

import com.vay.magaz.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Stream<Product> streamAllByTitleStartsWithIgnoreCase(String title);

    Stream<Product> streamAllBy();
}
