package ru.gb.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.market.model.Product;
import ru.gb.market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return  productRepository.findById(id);
    }

    public void deleteById(Long id) { productRepository.deleteById(id); }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findByCostBetween(int minPrice, int maxPrice) {
        return productRepository.findProductByCostBetween(minPrice, maxPrice);
    }
}
