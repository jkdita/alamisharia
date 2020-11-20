package id.co.alamisharia.service;

import id.co.alamisharia.entity.Product;
import id.co.alamisharia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    public List<Product> listProductBySellerId(int sellerId) {
        return repository.findBySellerId(sellerId);
    }

    public List<Product> searchProductByKeyword(String keyword) {
        return repository.findByNamaContains(keyword);
    }

}
