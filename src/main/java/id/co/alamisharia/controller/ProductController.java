package id.co.alamisharia.controller;

import id.co.alamisharia.entity.Product;
import id.co.alamisharia.service.ProductService;
import id.co.alamisharia.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private SellerService sellerService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        if(service.existsById(product.getId())) {
            product.setNama("Sudah Ada"); //TODO create general response body
            return product;
        }

        if(!sellerService.existsById(product.getSellerId())) {
            product.setNama("ID Seller Tidak Ada Di DB"); //TODO create general response body
            return product;
        }

        return service.saveProduct(product);
    }

    @GetMapping("/listProductBySellerId")
    public List<Product> listProductBySellerId(@RequestParam("SELLER_ID") int sellerId) {
        return service.listProductBySellerId(sellerId);
    }

    @GetMapping("/searchProductByKeyword")
    public List<Product> searchProductByKeyword(@RequestParam("keyword") String keyword) {
        return service.searchProductByKeyword(keyword);
    }
}
