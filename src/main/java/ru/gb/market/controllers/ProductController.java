package ru.gb.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.dto.ProductDto;
import ru.gb.market.model.Product;
import ru.gb.market.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private static final String MAX_INT ="2147483647";
    @GetMapping("/show_all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/show/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id).get());
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @PostMapping("/save")
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());

        productService.save(product);
        return new ProductDto(product);
    }
    @GetMapping("/cost")
    public List<Product> findByPrice(@RequestParam (name = "min", required = false, defaultValue ="0") int minPrice,
                                     @RequestParam (name = "max", required = false, defaultValue = MAX_INT) int maxPrice){
        return productService.findByCostBetween(minPrice, maxPrice);
    }


}
