package edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Schema(description = "role filter fields")
public record RoleRequestDto(
        @NotBlank(message = "name requerido")
        String name,
        @NotBlank(message = "description requerido")
        String description,
        @NotNull(message = "isEnabled requerido")
        Boolean isEnabled) implements Serializable {
}
