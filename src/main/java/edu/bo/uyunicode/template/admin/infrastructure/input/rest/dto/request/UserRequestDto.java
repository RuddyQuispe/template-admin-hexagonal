package edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Schema(description = "user info to create or update")
public record UserRequestDto(
        @NotBlank(message = "nickname requerido")
        String nickname,
        @NotBlank(message = "username requerido")
        String username,
        @NotBlank(message = "password requerido")
        String password,
        @NotNull(message = "isEnabled requerido")
        Boolean isEnabled) implements Serializable {
}
