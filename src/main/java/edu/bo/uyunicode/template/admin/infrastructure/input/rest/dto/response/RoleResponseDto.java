package edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "role response data")
public record RoleResponseDto(
        Integer roleId,
        String name,
        String description,
        Boolean isEnabled) implements Serializable {
}
