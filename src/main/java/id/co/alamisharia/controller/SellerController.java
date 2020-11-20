package id.co.alamisharia.controller;

import id.co.alamisharia.entity.Response;
import id.co.alamisharia.entity.Seller;
import id.co.alamisharia.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerController {
    @Autowired
    private SellerService service;

    @PostMapping("/addSeller")
    public Response addSeller(@RequestBody Seller seller) {
        if(service.existsById(seller.getId())) {
            return new Response(400, "Error", "Seller already exist!");
        }

        Seller result = service.saveSeller(seller);
        return new Response(200, "Success", "", result);
    }
}
