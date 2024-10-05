package org.api.authetication.domain.user;


import org.api.authetication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AdmInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
            User adminUser = new User();
            adminUser.setId(UUID.randomUUID().toString()); // ou use um UUID gerado de acordo com sua estratégia
            adminUser.setName("Admin");
            adminUser.setEmail("admin");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setRole(Role.ADMIN);

            userRepository.save(adminUser);

    }

}
