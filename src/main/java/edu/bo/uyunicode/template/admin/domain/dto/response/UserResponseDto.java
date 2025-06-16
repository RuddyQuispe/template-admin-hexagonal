package edu.bo.uyunicode.template.admin.domain.dto.response;

public record UserResponseDto(
        Integer userId,
        String nickname,
        String username,
        Boolean enabled) {
}
