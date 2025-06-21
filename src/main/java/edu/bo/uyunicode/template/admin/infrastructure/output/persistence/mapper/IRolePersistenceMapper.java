package edu.bo.uyunicode.template.admin.infrastructure.output.persistence.mapper;

import edu.bo.uyunicode.template.admin.domain.dto.RoleDto;
import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRolePersistenceMapper {
    RoleEntity toEntity(RoleDto dto);

    RoleDto toDto(RoleEntity entity);

    List<RoleDto> toDtos(List<RoleEntity> entities);

    List<RoleEntity> toEntities(List<RoleDto> dtos);
}
