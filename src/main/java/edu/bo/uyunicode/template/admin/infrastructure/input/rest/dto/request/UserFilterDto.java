package edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request;


public record UserFilterDto(
        String nickname,
        String username,
        String password,
        Boolean isEnabled) {
}
