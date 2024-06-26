package com.example.web_lapshop.repository;
import com.example.web_lapshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long > {
        UserEntity findByUsername(String username);

        UserEntity findByUsernameAndPassword(String username, String password);

        boolean existsByUsername(String username);
}
