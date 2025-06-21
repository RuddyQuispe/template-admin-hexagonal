package edu.bo.uyunicode.template.admin.infrastructure.output.persistence;

import edu.bo.uyunicode.template.admin.application.output.IRolePersistencePort;
import edu.bo.uyunicode.template.admin.application.output.IUserPersistencePort;
import edu.bo.uyunicode.template.admin.domain.dto.RoleDto;
import edu.bo.uyunicode.template.admin.domain.models.PaginatedDataDto;
import edu.bo.uyunicode.template.admin.domain.models.PaginationDto;
import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.entity.RoleEntity;
import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.mapper.IRolePersistenceMapper;
import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RolePersistenceAdapter implements IRolePersistencePort {

    private final IRolePersistenceMapper roleMapper;
    private final IRoleRepository roleRepository;

    @Override
    public Optional<RoleDto> findById(Integer id) {
        return this.roleRepository.findById(id)
                .map(this.roleMapper::toDto);
    }

    @Override
    public RoleDto save(RoleDto dto) {
        RoleEntity entity = roleMapper.toEntity(dto);
        entity = this.roleRepository.save(entity);
        return this.roleMapper.toDto(entity);
    }

    @Override
    public PaginatedDataDto<RoleDto> findByFilter(RoleDto dto, PaginationDto paginator) {
        Pageable pageable = PageRequest.of(paginator.pageNumber(), paginator.pageSize(), Sort.by(paginator.direction(), paginator.property()));
        Page<RoleEntity> pageRoles = this.roleRepository.findByFilter(dto.roleId(), dto.name(), dto.description(), dto.isEnabled(), pageable);
        List<RoleDto> rolesDtoPage = this.roleMapper.toDtos(pageRoles.getContent());
        return new PaginatedDataDto<>(rolesDtoPage, pageRoles.getNumber(), pageRoles.getSize(), pageRoles.getTotalPages(), pageRoles.getTotalElements());
    }
}
