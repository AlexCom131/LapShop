package com.example.web_lapshop.entity;

import jakarta.persistence.*;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private LapTopEntity laptop;

    public Purchase() {
    }

    public Long getId() {
        return id;
    }

    public Purchase setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public Purchase setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public LapTopEntity getLaptop() {
        return laptop;
    }

    public Purchase setLaptop(LapTopEntity laptop) {
        this.laptop = laptop;
        return this;
    }
}
