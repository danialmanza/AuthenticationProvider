package com.almawa.authenticationprovider.service;

import com.almawa.authenticationprovider.model.entity.UserEntity;

import java.util.List;

public interface SingupService {

    List<UserEntity> getAll();
    void createUser(UserEntity user);
    void updatePass(String username, String newPassword);
}
