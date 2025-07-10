package io.github.jinseoplee.demos.ss.repository;

import io.github.jinseoplee.demos.ss.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
