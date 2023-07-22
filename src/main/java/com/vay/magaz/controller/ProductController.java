package com.vay.magaz.controller;

import com.vay.magaz.store.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "home";
    }
}
