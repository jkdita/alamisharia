package id.co.alamisharia.controller;

import id.co.alamisharia.entity.Product;
import id.co.alamisharia.entity.Response;
import id.co.alamisharia.service.ProductService;
import id.co.alamisharia.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private SellerService sellerService;

    @PostMapping("/addProduct")
    public Response addProduct(@Valid @RequestBody Product product, Errors errors) { //@RequestBody Product product) {
        if(errors.hasErrors()) {
            List<String> errMsg = new ArrayList<>();
            errors.getAllErrors().forEach(o -> {
                errMsg.add(o.getDefaultMessage());
            });

            return new Response(400, "Error", errMsg.toString());
        }

        if(service.existsById(product.getId())) {
            return new Response(400, "Error", "Product already exist!");
        }

        if(!sellerService.existsById(product.getSellerId())) {
            return new Response(400, "Error", "Seller not found!");
        }

        Product result = service.saveProduct(product);
        return new Response(200, "Success", "", result);
    }

    @GetMapping("/listProductBySellerId")
    public Response listProductBySellerId(@RequestParam("SELLER_ID") int sellerId) {
        List<Product> result = service.listProductBySellerId(sellerId);
        return new Response(200, "Success", "", result);
    }

    @GetMapping("/searchProductByKeyword")
    public Response searchProductByKeyword(@RequestParam("keyword") String keyword) {
        List<Product> result = service.searchProductByKeyword(keyword);
        return new Response(200, "Success", "", result);
    }
}
