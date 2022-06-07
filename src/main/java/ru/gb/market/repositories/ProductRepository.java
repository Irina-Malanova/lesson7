package ru.gb.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.market.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
   // @Query("select p from Product p where p.cost <= :maxPrice and p.cost >= :minPrice")
    List<Product> findProductByCostBetween(int minPrice, int maxPrice);

}
