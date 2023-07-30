package br.com.projeto.ecommerce.dto;

import br.com.projeto.ecommerce.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
