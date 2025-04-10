package repository.jpa;

import model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Optional<Customer> findByEmail(String email);
    
    Optional<Customer> findByCpf(String cpf);
    
    List<Customer> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT c FROM Customer c JOIN Order o ON c.id = o.customer.id GROUP BY c.id ORDER BY COUNT(o) DESC")
    List<Customer> findTopCustomersByOrderCount();
}