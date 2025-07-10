package io.github.jinseoplee.demos.ss.controller;

import io.github.jinseoplee.demos.ss.dto.ProductDto;
import io.github.jinseoplee.demos.ss.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public String add(ProductDto productDto) {
        productService.save(productDto);
        return "redirect:/";
    }
}
