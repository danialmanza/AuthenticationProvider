package com.almawa.authenticationprovider.service.impl;

import com.almawa.authenticationprovider.model.entity.UserEntity;
import com.almawa.authenticationprovider.repository.UserRepository;
import com.almawa.authenticationprovider.service.SingupService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SingupServiceImpl implements SingupService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(UserEntity user) {
        String passEncoder = new BCryptPasswordEncoder().encode(user.getPassword());

        if (!isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email address");
        }

        if (!isValidPhone(user.getPhone())) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        UserEntity userEncode = UserEntity.builder()
                .name(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .id(user.getId())
                .password(passEncoder)
                .build();

        userRepository.save(userEncode);
    }

    @Override
    public void updatePass(String email, String newPassword) {
        Long id = userRepository.findByEmail(email).getId();
        if (id == null) {
            throw new IllegalArgumentException("User not found");
        }
        String passEncoder = new BCryptPasswordEncoder().encode(newPassword);
        userRepository.updatePasswordById(id, passEncoder);
    }

    private boolean isValidEmail(String email) {
        return email.contains("@");
    }

    private boolean isValidPhone(String phone) {
        int phoneLength = phone.length();
        return phoneLength >= 6 && phoneLength <= 10;
    }
}
