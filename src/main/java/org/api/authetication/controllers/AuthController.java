package org.api.authetication.controllers;

import org.api.authetication.domain.user.Role;
import org.api.authetication.domain.user.User;
import org.api.authetication.dto.LoginRequestDTO;
import org.api.authetication.dto.RegisterRequestDTO;
import org.api.authetication.dto.ResponseDTO;
import org.api.authetication.infra.security.TokenService;
import org.api.authetication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final TokenService tokenService;
    private final UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token, user.getRole()));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<User> user = this.repository.findByEmail(body.email());

        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setName(body.name());
            if (body.role() == null) {
                newUser.setRole(Role.USER);
            } else {
                newUser.setRole(body.role());
            }
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            userRepository.save(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token, newUser.getRole()));
        }
        return ResponseEntity.badRequest().build();
    }
}