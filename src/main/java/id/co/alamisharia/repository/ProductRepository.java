package id.co.alamisharia.repository;

import id.co.alamisharia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findBySellerId(int sellerId);

    List<Product> findByNamaContains(String keyword);
}
