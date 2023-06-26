package com.almawa.authenticationprovider.repository;

import com.almawa.authenticationprovider.model.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity u SET u.password = :password WHERE u.id = :userId")
    void updatePasswordById(Long userId, String password);
}

