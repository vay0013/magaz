package com.vay.magaz.controller;

import com.vay.magaz.database.entity.Product;
import com.vay.magaz.database.repository.ProductRepository;
import com.vay.magaz.mapper.ProductDtoMapper;
import com.vay.magaz.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductRepository productRepository;
    ProductService productService;
    ProductDtoMapper productDtoMapper;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.findAll());
        return "home";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        return productService.findById(id).map(product -> {
            model.addAttribute("product", product);
            return "product/product-info";
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


    }

    @Transactional
    @PostMapping("create")
    public String create(@RequestParam String title, @RequestParam String description,
                         @RequestParam int price, @RequestParam String city, Model model) {

        productService.create(Product.builder()
                .title(title)
                .description(description)
                .city(city)
                .price(price)
                .build());

        model.addAttribute("products", productService.findAll());
        return "redirect:/";
    }


    @Transactional
    @PostMapping("filter")
    public String filter(@RequestParam(value = "filter", required = false) Optional<String> optionalPrefixTitle,
                         Model model) {
        optionalPrefixTitle = optionalPrefixTitle.filter(prefixTitle -> !prefixTitle.trim().isEmpty());

        Stream<Product> projectStream = optionalPrefixTitle
                .map(productRepository::streamAllByTitleStartsWithIgnoreCase)
                .orElseGet(productRepository::streamAllBy);

        model.addAttribute("productsFilter", projectStream
                .map(productDtoMapper::makeProjectDto)
                .collect(Collectors.toList()));

        return "filter_html";
    }

    @Transactional
    @PostMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteById(id); // TODO: exception if return false
        return "redirect:/";
    }
}
