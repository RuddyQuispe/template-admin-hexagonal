package edu.bo.uyunicode.template.admin.infrastructure.input.rest;

import edu.bo.uyunicode.template.admin.application.input.IUserServicePort;
import edu.bo.uyunicode.template.admin.domain.dto.UserDto;
import edu.bo.uyunicode.template.admin.domain.exceptions.UserNotFoundException;
import edu.bo.uyunicode.template.admin.domain.models.ResponsePaginateDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request.UserFilterRequestDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request.UserRequestDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.response.UserResponseDto;
import edu.bo.uyunicode.template.admin.infrastructure.input.rest.mapper.IUserRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserServicePort userServicePort;
    private final IUserRestMapper userMapper;

    @Operation(summary = "Find user by user id", description = "Get data info by user")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> findById(@PathVariable @NotNull Integer id) {
        UserResponseDto response = this.userServicePort.findById(id)
                .map(this.userMapper::toResponse)
                .orElseThrow(() -> new UserNotFoundException("No existe usuario con id: %s".formatted(id)));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Save new user", description = "Save new user account")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> save(@RequestBody @Valid UserRequestDto request) {
        UserResponseDto response = this.userMapper.toResponse(this.userServicePort.save(this.userMapper.toDto(request)));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update user data", description = "Update info by user id")
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> update(@PathVariable("id") Integer id, @RequestBody @Valid UserRequestDto request) {
        UserResponseDto response = this.userMapper.toResponse(this.userServicePort.update(id, this.userMapper.toDto(request)));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find all users", description = "Get users by filters and pagination")
    @PostMapping(path = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePaginateDto<UserResponseDto>> findByFilter(@RequestBody @Valid UserFilterRequestDto request) {
        UserDto filter = this.userMapper.toDto(request.filter());
        ResponsePaginateDto<UserDto> response = this.userServicePort.findByFilters(filter, request.pagination());
        ResponsePaginateDto<UserResponseDto> responseUsers = this.userMapper.toResponseFilter(response);
        return ResponseEntity.ok(responseUsers);
    }
}
