package org.api.authetication.controllers;


import org.api.authetication.domain.user.User;
import org.api.authetication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("sucesso!");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        if (id == null || !userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping("/getAll")
    public ResponseEntity getAll(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
