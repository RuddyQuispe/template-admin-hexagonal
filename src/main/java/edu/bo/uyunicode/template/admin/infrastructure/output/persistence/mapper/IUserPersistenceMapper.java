package edu.bo.uyunicode.template.admin.infrastructure.output.persistence.mapper;

import edu.bo.uyunicode.template.admin.domain.dto.UserDto;
import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserPersistenceMapper {
    UserEntity toEntity(UserDto dto);

    List<UserEntity> toEntities(List<UserDto> dtos);

    UserDto toDto(UserEntity entity);

    List<UserDto> toDtos(List<UserEntity> entities);
}
