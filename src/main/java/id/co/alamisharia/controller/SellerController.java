package id.co.alamisharia.controller;

import id.co.alamisharia.entity.Seller;
import id.co.alamisharia.enums.ResponseEnum;
import id.co.alamisharia.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SellerController {
    @Autowired
    private SellerService service;

    /*@PostMapping("/addSeller")
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
    }*/

    @PostMapping("/addSeller")
    public ResponseEntity<ResponseEnum> addSeller(@Valid @RequestBody Seller seller, Errors errors) {
        try {
            ResponseEnum response;

            if (errors.hasErrors()) {
                FieldError fe = errors.getFieldError();
                response = ResponseEnum.BAD_REQUEST;
                response.setMessage(fe.getField() + " " + fe.getDefaultMessage());
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            if (service.existsById(seller.getId())) {
                response = ResponseEnum.BAD_REQUEST;
                response.setMessage("Seller Already Exist");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            Seller s = service.saveSeller(seller);
            response = ResponseEnum.SUCCESS;
            response.setData(s);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
