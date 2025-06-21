package edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "user filter fields")
public record UserFilterDto(
        String nickname,
        String username,
        String password,
        Boolean isEnabled) {
}
