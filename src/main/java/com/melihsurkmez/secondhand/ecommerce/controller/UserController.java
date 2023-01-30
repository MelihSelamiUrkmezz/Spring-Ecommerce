package com.melihsurkmez.secondhand.ecommerce.controller;

import com.melihsurkmez.secondhand.ecommerce.DTO.CreateUserRequest;
import com.melihsurkmez.secondhand.ecommerce.DTO.UpdateUserRequest;
import com.melihsurkmez.secondhand.ecommerce.DTO.UserResponse;
import com.melihsurkmez.secondhand.ecommerce.model.User;
import com.melihsurkmez.secondhand.ecommerce.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUserbyEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserbyEmail(email));
    }


    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest newUser){
        return ResponseEntity.ok(userService.createUser(newUser));
    }

    @PutMapping("/{email}")
    public  ResponseEntity<UserResponse> updateUser(@PathVariable String email,@RequestBody UpdateUserRequest updatedUser){
        return ResponseEntity.ok(userService.updateUser(email,updatedUser));
    }

    @PatchMapping("/{email}")
    public ResponseEntity<Void> deactiveUser(@PathVariable String email){
        userService.deactiveUser(email);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{email}/activate")
    public ResponseEntity<Void> activateUser(@PathVariable String email){
        userService.activateUser(email);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{email}")
    public ResponseEntity<User> deleteUserbyEmail(@PathVariable String email){
        userService.deleteUserbyEmail(email);
        return ResponseEntity.ok().build();
    }



}
