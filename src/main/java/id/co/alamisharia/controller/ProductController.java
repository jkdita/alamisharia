package id.co.alamisharia.controller;

import id.co.alamisharia.entity.Product;
import id.co.alamisharia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/listProductBySellerId")
    public List<Product> getProductBySellerId(@RequestParam("SELLER_ID") int sellerId) {
        return service.getProductsBySellerId(sellerId);
    }
}
