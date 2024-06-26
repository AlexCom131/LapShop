package com.example.web_lapshop.service;

import com.example.web_lapshop.entity.LapTopEntity;
import com.example.web_lapshop.entity.UserEntity;
import com.example.web_lapshop.exception.UserAlreadyExistExeption;
import com.example.web_lapshop.repository.LapTopRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LapTopService {

    @Autowired
    private LapTopRepository lapTopRepository;

    public LapTopEntity saveLapTop(LapTopEntity laptop) {

        return lapTopRepository.save(laptop);
    }

    public List<LapTopEntity> getAllLaptops() {

        return lapTopRepository.findAll();
    }

    public List<LapTopEntity> findLaptopsByIds(List<Long> ids) {
        return lapTopRepository.findAllById(ids);
    }

    public LapTopEntity findById(Long id) {
        return lapTopRepository.findById(id).orElse(null);
    }

}


