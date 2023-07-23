package com.vay.magaz.controller;

import com.vay.magaz.store.entity.ProductEntity;
import com.vay.magaz.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "home";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        return productRepository.findById(id).map(product -> {
            model.addAttribute("product", product);
            return "product-info";
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


    }

    @PostMapping("/")
    public String create(@RequestParam String title, @RequestParam String description,
                         @RequestParam int price, @RequestParam String city, Model model) {

        productRepository.save(ProductEntity.builder()
                .title(title)
                .description(description)
                .city(city)
                .price(price)
                .build());

        model.addAttribute("products", productRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/";
    }
}
