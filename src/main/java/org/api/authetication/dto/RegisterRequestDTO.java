package org.api.authetication.dto;

import org.api.authetication.domain.user.Role;

public record RegisterRequestDTO(String name, String email, String password, Role role) {
}
