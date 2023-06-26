package com.almawa.authenticationprovider.controller.impl;

import com.almawa.authenticationprovider.controller.SignupController;
import com.almawa.authenticationprovider.mapper.UserMapper;
import com.almawa.authenticationprovider.model.dto.UserDTO;
import com.almawa.authenticationprovider.model.dto.UserToUpdateDTO;
import com.almawa.authenticationprovider.model.entity.UserEntity;
import com.almawa.authenticationprovider.service.SingupService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/auth")
public class SignupControllerImpl implements SignupController {
    @Autowired
    SingupService singupService;
    @Autowired
    UserMapper userMapper;

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserEntity> userEntityList = singupService.getAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserEntity user : userEntityList) {
            userDTOList.add(userMapper.toDTO(user));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTOList);
    }

    @Override
    @PostMapping(path = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(UserDTO user) {
        UserEntity userEntity = userMapper.toEntity(user);
        singupService.createUser(userEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @Override
    @PutMapping(path = "/updatepass", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserToUpdateDTO> UpdateUserPass(UserToUpdateDTO userToUpdateDTO) {
        singupService.updatePass(userToUpdateDTO.getEmail(), userToUpdateDTO.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(userToUpdateDTO);
    }
}
