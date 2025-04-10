package repository.jpa;

import model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findByCategory(String category);
    
    List<Product> findByNameContainingIgnoreCase(String name);
    
    Optional<Product> findBySku(String sku);
    
    List<Product> findByStockQuantityLessThan(Integer quantity);
    
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    
    @Query("SELECT p FROM Product p WHERE p.brand = ?1 AND p.category = ?2")
    List<Product> findByBrandAndCategory(String brand, String category);
}