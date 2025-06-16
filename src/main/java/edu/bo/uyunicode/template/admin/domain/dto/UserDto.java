package edu.bo.uyunicode.template.admin.domain.dto;

public record UserDto(
        Integer userId,
        String nickname,
        String username,
        String password,
        Boolean enabled) {
}
