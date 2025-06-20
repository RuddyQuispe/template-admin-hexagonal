package edu.bo.uyunicode.template.admin.infrastructure.input.rest.mapper;


import edu.bo.uyunicode.template.admin.domain.dto.UserDto;
import edu.bo.uyunicode.template.admin.domain.models.ResponsePaginateDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request.UserFilterDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request.UserRequestDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * mapping interface for request and response dto
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserRestMapper {
    UserDto toDto(UserFilterDto filterDto);

    UserDto toDto(UserRequestDto requestDto);

    UserResponseDto toResponse(UserDto dto);

    List<UserResponseDto> toResponse(List<UserDto> dtos);

    ResponsePaginateDto<UserResponseDto> toResponseFilter(ResponsePaginateDto<UserDto> responseFilter);
}
