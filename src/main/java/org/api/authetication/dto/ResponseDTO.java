package org.api.authetication.dto;

import org.api.authetication.domain.user.Role;

public record ResponseDTO(String name, String token, Role role) {
}
