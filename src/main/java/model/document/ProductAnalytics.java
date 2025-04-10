package model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//Explication

@Document(collection = "product_analytics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAnalytics {
    
    @Id
    private String id;
    
    private String productSku;
    
    private Long productId;
    
    private String productName;
    
    private Map<String, Integer> viewsByDate = new HashMap<>();
    
    private Map<String, Integer> purchasesByDate = new HashMap<>();
    
    private Double averageRating;
    
    private Integer totalReviews;
    
    private Map<String, Integer> ratingDistribution = new HashMap<>();
    
    private LocalDateTime lastUpdated;
    
    public void incrementViews(String date) {
        viewsByDate.put(date, viewsByDate.getOrDefault(date, 0) + 1);
        lastUpdated = LocalDateTime.now();
    }
    
    public void incrementPurchases(String date) {
        purchasesByDate.put(date, purchasesByDate.getOrDefault(date, 0) + 1);
        lastUpdated = LocalDateTime.now();
    }
    
    public void addRating(Integer rating) {
        ratingDistribution.put(rating.toString(), ratingDistribution.getOrDefault(rating.toString(), 0) + 1);
        recalculateAverageRating();
        lastUpdated = LocalDateTime.now();
    }
    
    private void recalculateAverageRating() {
        int totalRatings = ratingDistribution.values().stream().mapToInt(Integer::intValue).sum();
        double sumRatings = ratingDistribution.entrySet().stream()
            .mapToDouble(e -> Integer.parseInt(e.getKey()) * e.getValue())
            .sum();
        
        this.averageRating = sumRatings / totalRatings;
        this.totalReviews = totalRatings;
    }
}