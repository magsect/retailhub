package model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "customer_activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerActivity {
    
    @Id
    private String id;
    
    private Long customerId;
    
    private String customerEmail;
    
    private List<PageView> pageViews = new ArrayList<>();
    
    private List<ProductView> productViews = new ArrayList<>();
    
    private List<SearchQuery> searchQueries = new ArrayList<>();
    
    private List<CartAction> cartActions = new ArrayList<>();
    
    private LocalDateTime lastActive;
    
    public void addPageView(String page, String referrer) {
        pageViews.add(new PageView(page, referrer, LocalDateTime.now()));
        lastActive = LocalDateTime.now();
    }
    
    public void addProductView(Long productId, String productName) {
        productViews.add(new ProductView(productId, productName, LocalDateTime.now()));
        lastActive = LocalDateTime.now();
    }
    
    public void addSearchQuery(String query, Integer resultCount) {
        searchQueries.add(new SearchQuery(query, resultCount, LocalDateTime.now()));
        lastActive = LocalDateTime.now();
    }
    
    public void addCartAction(CartActionType type, Long productId, String productName, Integer quantity) {
        cartActions.add(new CartAction(type, productId, productName, quantity, LocalDateTime.now()));
        lastActive = LocalDateTime.now();
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PageView {
        private String page;
        private String referrer;
        private LocalDateTime timestamp;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductView {
        private Long productId;
        private String productName;
        private LocalDateTime timestamp;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchQuery {
        private String query;
        private Integer resultCount;
        private LocalDateTime timestamp;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CartAction {
        private CartActionType actionType;
        private Long productId;
        private String productName;
        private Integer quantity;
        private LocalDateTime timestamp;
    }
    
    public enum CartActionType {
        ADD, REMOVE, UPDATE, CHECKOUT
    }
}