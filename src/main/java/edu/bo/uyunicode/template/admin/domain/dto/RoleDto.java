package edu.bo.uyunicode.template.admin.domain.dto;

public record RoleDto(
        Integer roleId,
        String name,
        String description,
        Boolean isEnabled) {
}
