package edu.bo.uyunicode.template.admin.infrastructure.input.rest;

import edu.bo.uyunicode.template.admin.application.input.IRoleServicePort;
import edu.bo.uyunicode.template.admin.domain.dto.RoleDto;
import edu.bo.uyunicode.template.admin.domain.exceptions.ModelNotFoundException;
import edu.bo.uyunicode.template.admin.domain.models.PaginatedDataDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request.RoleFilterRequestDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request.RoleRequestDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.response.RoleResponseDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.mapper.IRoleRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/role")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleServicePort roleServicePort;
    private final IRoleRestMapper roleMapper;

    @Operation(summary = "Find user by role id", description = "Get data info by role")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDto> findById(@PathVariable @NotNull Integer id) {
        RoleResponseDto response = this.roleServicePort.findById(id)
                .map(this.roleMapper::toResponse)
                .orElseThrow(() -> new ModelNotFoundException("No existe rol con id: %s".formatted(id)));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Save new role", description = "Save new role")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDto> save(@RequestBody @Valid RoleRequestDto request) {
        RoleResponseDto response = this.roleMapper.toResponse(this.roleServicePort.save(this.roleMapper.toDto(request)));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update role data", description = "Update info by role id")
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDto> update(@PathVariable("id") Integer id, @RequestBody @Valid RoleRequestDto request) {
        RoleResponseDto response = this.roleMapper.toResponse(this.roleServicePort.update(id, this.roleMapper.toDto(request)));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find all role", description = "Get roles by filters and pagination")
    @PostMapping(path = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaginatedDataDto<RoleResponseDto>> findByFilter(@RequestBody @Valid RoleFilterRequestDto request) {
        RoleDto filter = this.roleMapper.toDto(request.filter());
        PaginatedDataDto<RoleDto> response = this.roleServicePort.findByFilters(filter, request.pagination());
        PaginatedDataDto<RoleResponseDto> responseUsers = this.roleMapper.toResponseFilter(response);
        return ResponseEntity.ok(responseUsers);
    }
}
