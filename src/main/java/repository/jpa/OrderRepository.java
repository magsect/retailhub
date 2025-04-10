package repository.jpa;

import model.entity.Customer;
import model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    List<Order> findByCustomer(Customer customer);
    
    List<Order> findByStatus(Order.OrderStatus status);
    
    List<Order> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);
    
    Optional<Order> findByOrderNumber(String orderNumber);
    
    @Query("SELECT o FROM Order o WHERE o.totalAmount > ?1")
    List<Order> findHighValueOrders(BigDecimal minAmount);
    
    @Query("SELECT o FROM Order o WHERE o.customer.id = ?1 ORDER BY o.orderDate DESC")
    List<Order> findRecentOrdersByCustomer(Long customerId);
}