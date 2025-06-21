package edu.bo.uyunicode.template.admin.infrastructure.input.rest.mapper;

import edu.bo.uyunicode.template.admin.domain.dto.RoleDto;
import edu.bo.uyunicode.template.admin.domain.models.PaginatedDataDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request.RoleFilterDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request.RoleRequestDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.response.RoleResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRoleRestMapper {
    RoleDto toDto(RoleRequestDto requestDto);

    RoleDto toDto(RoleFilterDto filterDto);

    RoleResponseDto toResponse(RoleDto dto);

    List<RoleResponseDto> toResponseDto(List<RoleDto> dtos);

    PaginatedDataDto<RoleResponseDto> toResponseFilter(PaginatedDataDto<RoleDto> dtos);
}
