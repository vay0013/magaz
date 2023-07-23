package com.vay.magaz.controller;

import com.vay.magaz.store.entity.ProductEntity;
import com.vay.magaz.store.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "home";
    }

    @PostMapping("/")
    public String create(@RequestParam String title, @RequestParam String description,
                         @RequestParam double price, @RequestParam String city, Model model) {

        productRepository.save(ProductEntity.builder()
                .title(title)
                .description(description)
                .city(city)
                .price(price)
                .build());

        model.addAttribute("products", productRepository.findAll());
        return "redirect:/";
    }
}
