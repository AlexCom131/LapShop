package com.example.web_lapshop.repository;

import com.example.web_lapshop.entity.LapTopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapTopRepository extends JpaRepository<LapTopEntity, Long> {
}
