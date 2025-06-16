package edu.bo.uyunicode.template.admin.domain.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

@Schema(description = "public user info")
public record UserResponseDto(
        Integer userId,
        String nickname,
        String username,
        Boolean isEnabled) implements Serializable {
}
