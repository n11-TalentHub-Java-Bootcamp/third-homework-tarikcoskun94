package com.n11.thirdhomeworktarikcoskun94.controller;

import com.n11.thirdhomeworktarikcoskun94.dto.UserDTO;
import com.n11.thirdhomeworktarikcoskun94.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {

        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping(value = "/with-id/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable String id) {

        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {

        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/with-id/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id) {

        userService.deleteUserById(id);
        String responseMessage = "User has been deleted by id: " + id;

        return ResponseEntity.ok(responseMessage);
    }
}
