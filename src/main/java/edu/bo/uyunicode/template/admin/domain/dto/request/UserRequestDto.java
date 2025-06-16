package edu.bo.uyunicode.template.admin.domain.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record UserRequestDto(
        @NotBlank(message = "nickname requerido")
        String nickname,
        @NotBlank(message = "username requerido")
        String username,
        @NotBlank(message = "password requerido")
        String password,
        @NotBlank(message = "enabled requerido")
        Boolean enabled) implements Serializable {
}
