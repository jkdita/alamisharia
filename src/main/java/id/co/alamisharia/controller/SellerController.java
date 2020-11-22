package id.co.alamisharia.controller;

import id.co.alamisharia.entity.Response;
import id.co.alamisharia.entity.Seller;
import id.co.alamisharia.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SellerController {
    @Autowired
    private SellerService service;

    @PostMapping("/addSeller")
    public Response addSeller(@Valid @RequestBody Seller seller, Errors errors) {
        if(errors.hasErrors()) {
            FieldError fe = errors.getFieldError();
            String em = fe.getField() + " " + fe.getDefaultMessage();
            return new Response(400, "Error", em);
        }

        if(service.existsById(seller.getId())) {
            return new Response(400, "Error", "Seller already exist!");
        }

        Seller result = service.saveSeller(seller);
        return new Response(200, "Success", "", result);
    }
}
