package id.co.alamisharia.controller;

import id.co.alamisharia.entity.Seller;
import id.co.alamisharia.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerController {
    @Autowired
    private SellerService service;

    @PostMapping("/addSeller")
    public Seller addSeller(@RequestBody Seller seller) {
        return service.saveSeller(seller);
    }
}
