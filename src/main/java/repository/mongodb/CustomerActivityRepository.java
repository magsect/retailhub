package repository.mongodb;

import model.document.CustomerActivity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerActivityRepository extends MongoRepository<CustomerActivity, String> {
    
    Optional<CustomerActivity> findByCustomerId(Long customerId);
    
    Optional<CustomerActivity> findByCustomerEmail(String email);
    
    @Query("{ 'lastActive': { $gte: ?0 } }")
    List<CustomerActivity> findRecentlyActiveCustomers(LocalDateTime since);
    
    @Query("{ 'productViews.productId': ?0 }")
    List<CustomerActivity> findCustomersWhoViewedProduct(Long productId);
    
    @Query("{ 'searchQueries.query': { $regex: ?0, $options: 'i' } }")
    List<CustomerActivity> findBySearchQueryContaining(String searchTerm);
}