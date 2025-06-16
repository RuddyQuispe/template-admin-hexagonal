package edu.bo.uyunicode.template.admin.domain.mappers;

import edu.bo.uyunicode.template.admin.domain.dto.UserDto;
import edu.bo.uyunicode.template.admin.domain.dto.request.UserRequestDto;
import edu.bo.uyunicode.template.admin.domain.dto.response.UserResponseDto;
import edu.bo.uyunicode.template.admin.domain.entity.UserEntity;
import edu.bo.uyunicode.template.admin.domain.models.ResponsePaginateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserEntity toEntity(UserDto dto);

    List<UserEntity> toEntities(List<UserDto> dtos);

    UserDto toDto(UserEntity entity);

    UserDto toDto(UserRequestDto requestDto);

    List<UserDto> toDtos(List<UserEntity> entities);

    UserResponseDto toResponse(UserDto dto);

    List<UserResponseDto> toResponse(List<UserDto> dtos);

    ResponsePaginateDto<UserResponseDto> toResponseFilter(ResponsePaginateDto<UserDto> responseFilter);
}
