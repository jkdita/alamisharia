package id.co.alamisharia.repository;

import id.co.alamisharia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findBySellerId(long sellerId);

    List<Product> findByNamaContains(String keyword);

    boolean existsByNama(String nama);
}
