package com.transaction.api.transactionmicroserviceapi.controller;

import com.transaction.api.transactionmicroserviceapi.dto.UserDTO;
import com.transaction.api.transactionmicroserviceapi.repository.UserRepository;
import com.transaction.api.transactionmicroserviceapi.service.ApiServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApiServices services;

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        return services.createUser(userDTO);
    }

    @GetMapping("/list-users")
    @ResponseBody
    public ResponseEntity listUsers() {
        var users = userRepository.findAll();

        if(users.isEmpty()) {
            return ResponseEntity.badRequest().body("Não há usuários cadastrados");
        }

        return ResponseEntity.ok(users);
    }
}
