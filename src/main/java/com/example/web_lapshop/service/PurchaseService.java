package com.example.web_lapshop.service;

import com.example.web_lapshop.entity.LapTopEntity;
import com.example.web_lapshop.entity.Purchase;
import com.example.web_lapshop.entity.UserEntity;
import com.example.web_lapshop.repository.LapTopRepository;
import com.example.web_lapshop.repository.PurchaseRepository;
import com.example.web_lapshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LapTopRepository lapTopRepository;

    public void makePurchase(Long userId, Long laptopId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        LapTopEntity laptop = lapTopRepository.findById(laptopId).orElseThrow(() -> new RuntimeException("Laptop not found"));

        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setLaptop(laptop);

        purchaseRepository.save(purchase);
    }
}
