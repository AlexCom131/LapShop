package com.example.web_lapshop.entity;

import jakarta.persistence.*;

@Entity
public class LapTopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String namelaptop;
    private String gpu;
    private String cdu;
    private String price;
    private String storage;
    private String photoFileName;

    public LapTopEntity() {
    }

    public Long getId() {
        return id;
    }

    public LapTopEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNamelaptop() {
        return namelaptop;
    }

    public LapTopEntity setNamelaptop(String namelaptop) {
        this.namelaptop = namelaptop;
        return this;
    }

    public String getGpu() {
        return gpu;
    }

    public LapTopEntity setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    public String getCdu() {
        return cdu;
    }

    public LapTopEntity setCdu(String cdu) {
        this.cdu = cdu;
        return this;
    }

    public String getStorage() {
        return storage;
    }

    public LapTopEntity setStorage(String storage) {
        if (storage.equals("SSD") || storage.equals("HDD")) {
            this.storage = storage;
            return this;
        } else {
            throw new IllegalArgumentException("Недійсний тип зберігання. Дозволені лише <SSD> і <HDD>.");
        }
    }

    public String getPrice() {
        return price;
    }

    public LapTopEntity setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public LapTopEntity setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
        return this;
    }
}
