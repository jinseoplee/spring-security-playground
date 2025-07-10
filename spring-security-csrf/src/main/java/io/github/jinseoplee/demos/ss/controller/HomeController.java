package io.github.jinseoplee.demos.ss.controller;

import io.github.jinseoplee.demos.ss.dto.ProductDto;
import io.github.jinseoplee.demos.ss.entity.Product;
import io.github.jinseoplee.demos.ss.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("productDto", new ProductDto());
        return "index";
    }
}
