package com.vay.magaz.controller;

//import com.vay.magaz.service.ProductService;
import com.vay.magaz.service.ProductService;
import com.vay.magaz.store.entity.Product;
import com.vay.magaz.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.server.ResponseStatusException;

        import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;

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


    @PostMapping("create")
    public String create(@RequestParam String title, @RequestParam String description,
                         @RequestParam int price, @RequestParam String city, Model model) {

        productService.create(Product.builder()
                    .title(title)
                    .description(description)
                    .city(city)
                    .price(price)
                    .build());

        model.addAttribute("products", productRepository.findAll());
        return "redirect:/";
    }


//    @PostMapping("filter")
//    public String filter(@RequestParam(value = "filter", required = false) Optional<String> optionalPrefixTitle,
//                         Model model) {
//        optionalPrefixTitle = optionalPrefixTitle.filter(prefixTitle -> !prefixTitle.trim().isEmpty());
//        if (optionalPrefixTitle.isPresent()) {
//            model.addAttribute("productsFilter",
//                    productRepository.streamAllByTitleStartsWithIgnoreCase(String.valueOf(optionalPrefixTitle)));
//        }
//        return "redirect:/";
//    }

    @Transactional
    @PostMapping("/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id); // TODO: exception if return false
        return "redirect:/";
    }
}
