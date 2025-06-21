package edu.bo.uyunicode.template.admin.application.service;

import edu.bo.uyunicode.template.admin.application.input.IRoleServicePort;
import edu.bo.uyunicode.template.admin.application.output.IRolePersistencePort;
import edu.bo.uyunicode.template.admin.domain.dto.RoleDto;
import edu.bo.uyunicode.template.admin.domain.exceptions.ModelNotFoundException;
import edu.bo.uyunicode.template.admin.domain.models.PaginatedDataDto;
import edu.bo.uyunicode.template.admin.domain.models.PaginationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImp implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;


    @Override
    public Optional<RoleDto> findById(Integer id) {
        return this.rolePersistencePort.findById(id);
    }

    @Override
    public RoleDto save(RoleDto dto) {
        return this.rolePersistencePort.save(dto);
    }

    @Override
    public RoleDto update(Integer id, RoleDto dto) {
        return this.rolePersistencePort.findById(id)
                .map(r -> {
                    RoleDto role = new RoleDto(r.roleId(), r.name(), r.description(), r.isEnabled());
                    return this.rolePersistencePort.save(role);
                }).orElseThrow(() -> new ModelNotFoundException("rol no existe ID: " + id));
    }

    @Override
    public PaginatedDataDto<RoleDto> findByFilters(RoleDto filters, PaginationDto paginator) {
        return this.rolePersistencePort.findByFilter(filters, paginator);
    }
}
