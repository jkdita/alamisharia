package id.co.alamisharia.service;

import id.co.alamisharia.entity.Seller;
import id.co.alamisharia.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    private SellerRepository repository;

    public Seller saveSeller(Seller seller) {
        return repository.save(seller);
    }
}
