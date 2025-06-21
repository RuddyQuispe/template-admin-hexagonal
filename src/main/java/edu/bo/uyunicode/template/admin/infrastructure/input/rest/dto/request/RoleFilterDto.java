package edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "role filter fields")
public record RoleFilterDto(
        Integer roleId,
        String name,
        String description,
        Boolean isEnabled) implements Serializable {
}
