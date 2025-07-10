package io.github.jinseoplee.demos.ss.service;

import io.github.jinseoplee.demos.ss.dto.ProductDto;
import io.github.jinseoplee.demos.ss.entity.Product;
import io.github.jinseoplee.demos.ss.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void save(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();

        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
