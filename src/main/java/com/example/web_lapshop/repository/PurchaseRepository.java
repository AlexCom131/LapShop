package com.example.web_lapshop.repository;

import com.example.web_lapshop.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository  extends JpaRepository<Purchase, Long> {
}
