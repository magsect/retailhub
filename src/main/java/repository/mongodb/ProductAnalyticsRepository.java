package repository.mongodb;

import model.document.ProductAnalytics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductAnalyticsRepository extends MongoRepository<ProductAnalytics, String> {
    
    Optional<ProductAnalytics> findByProductId(Long productId);
    
    Optional<ProductAnalytics> findByProductSku(String sku);
    
    @Query("{ 'averageRating': { $gte: ?0 } }")
    List<ProductAnalytics> findByMinimumRating(Double rating);
    
    @Query("{ 'totalReviews': { $gte: ?0 } }")
    List<ProductAnalytics> findByMinimumReviews(Integer reviewCount);
    
    @Query(value = "{}", sort = "{ 'averageRating': -1 }")
    List<ProductAnalytics> findTopRatedProducts();
}