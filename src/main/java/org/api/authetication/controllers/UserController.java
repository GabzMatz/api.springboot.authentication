package org.api.authetication.controllers;


import org.api.authetication.domain.user.Role;
import org.api.authetication.domain.user.User;
import org.api.authetication.dto.UpdateRequestDTO;
import org.api.authetication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("sucesso!");
    }

    @RequestMapping("/getAll")
    public ResponseEntity getAll(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        if (id == null || !userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        User userToDelete = userRepository.findById(id).orElse(null);
        if (userToDelete == null) {
            return ResponseEntity.notFound().build();
        }
        if (userToDelete.getRole() == Role.ADMIN) {
            return ResponseEntity.status(403).build();
        }
        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }



    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UpdateRequestDTO updateRequestDTO) {
        // Verifica se o ID é válido e se o usuário existe no repositório
        if (id == null || !userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Localiza o usuário a ser atualizado
        User userToUpdate = userRepository.findById(id).orElse(null);

        // Verifica se o usuário a ser atualizado foi encontrado
        if (userToUpdate == null) {
            return ResponseEntity.notFound().build();
        }

        // Atualiza os dados do usuário
        userToUpdate.setName(updateRequestDTO.name());


        // Salva as mudanças no repositório
        userRepository.save(userToUpdate);

        return ResponseEntity.ok(userToUpdate);
    }



}
