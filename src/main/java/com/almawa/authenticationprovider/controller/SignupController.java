package com.almawa.authenticationprovider.controller;

import com.almawa.authenticationprovider.model.dto.UserDTO;
import com.almawa.authenticationprovider.model.dto.UserToUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SignupController {
    ResponseEntity<List<UserDTO>> getAllUsers();
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user);
    ResponseEntity<UserToUpdateDTO> UpdateUserPass(@RequestBody UserToUpdateDTO userToUpdateDTO);
}
