package org.api.authetication.repositories;

import org.api.authetication.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);;
    User findByName(String name);

}
