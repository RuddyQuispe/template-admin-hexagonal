package edu.bo.uyunicode.template.admin.infrastructure.input.rest;

import edu.bo.uyunicode.template.admin.application.input.IUserServicePort;
import edu.bo.uyunicode.template.admin.domain.dto.UserDto;
import edu.bo.uyunicode.template.admin.domain.dto.request.UserFilterRequestDto;
import edu.bo.uyunicode.template.admin.domain.dto.request.UserRequestDto;
import edu.bo.uyunicode.template.admin.domain.dto.response.UserResponseDto;
import edu.bo.uyunicode.template.admin.domain.exceptions.UserNotFoundException;
import edu.bo.uyunicode.template.admin.domain.mappers.IUserMapper;
import edu.bo.uyunicode.template.admin.domain.models.RequestPaginator;
import edu.bo.uyunicode.template.admin.domain.models.ResponsePaginateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private IUserMapper userMapper;

    @InjectMocks
    private UserController userController;

    private UserDto userDto;
    private UserRequestDto userRequestDto;
    private UserResponseDto userResponseDto;
    private RequestPaginator paginator;
    private UserFilterRequestDto filterRequestDto;

    @BeforeEach
    void setUp() {
        // Setup test data
        userDto = new UserDto(1, "nickname1", "username1", "password1", true);
        userRequestDto = new UserRequestDto("nickname1", "username1", "password1", true);
        userResponseDto = new UserResponseDto(1, "nickname1", "username1", true);
        paginator = new RequestPaginator(Direction.ASC, "userId", 0, 10);
        filterRequestDto = new UserFilterRequestDto(userRequestDto, paginator);
    }

    @Test
    void findById_WhenUserExists_ReturnsUserResponseDto() {
        // Arrange
        Integer userId = 1;
        when(userServicePort.findById(userId)).thenReturn(Optional.of(userDto));
        when(userMapper.toResponse(userDto)).thenReturn(userResponseDto);

        // Act
        ResponseEntity<UserResponseDto> response = userController.findById(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResponseDto, response.getBody());
        verify(userServicePort).findById(userId);
        verify(userMapper).toResponse(userDto);
    }

    @Test
    void findById_WhenUserDoesNotExist_ThrowsUserNotFoundException() {
        // Arrange
        Integer userId = 999;
        when(userServicePort.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userController.findById(userId));
        verify(userServicePort).findById(userId);
        verify(userMapper, never()).toResponse(any(UserDto.class));
    }

    @Test
    void save_ValidRequest_ReturnsUserResponseDto() {
        // Arrange
        when(userMapper.toDto(userRequestDto)).thenReturn(userDto);
        when(userServicePort.save(userDto)).thenReturn(userDto);
        when(userMapper.toResponse(userDto)).thenReturn(userResponseDto);

        // Act
        ResponseEntity<UserResponseDto> response = userController.save(userRequestDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResponseDto, response.getBody());
        verify(userMapper).toDto(userRequestDto);
        verify(userServicePort).save(userDto);
        verify(userMapper).toResponse(userDto);
    }

    @Test
    void update_ValidRequest_ReturnsUserResponseDto() {
        // Arrange
        Integer userId = 1;
        when(userMapper.toDto(userRequestDto)).thenReturn(userDto);
        when(userServicePort.update(eq(userId), any(UserDto.class))).thenReturn(userDto);
        when(userMapper.toResponse(userDto)).thenReturn(userResponseDto);

        // Act
        ResponseEntity<UserResponseDto> response = userController.update(userId, userRequestDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResponseDto, response.getBody());
        verify(userMapper).toDto(userRequestDto);
        verify(userServicePort).update(eq(userId), any(UserDto.class));
        verify(userMapper).toResponse(userDto);
    }

    @Test
    void findByFilter_ValidRequest_ReturnsResponsePaginateDto() {
        // Arrange
        UserDto filterDto = new UserDto(null, "nickname1", "username1", "password1", true);
        ResponsePaginateDto<UserDto> servicePaginateResponse = new ResponsePaginateDto<>(
                List.of(userDto), 0, 10, 1, 1L);
        ResponsePaginateDto<UserResponseDto> expectedResponse = new ResponsePaginateDto<>(
                List.of(userResponseDto), 0, 10, 1, 1L);

        when(userMapper.toDto(userRequestDto)).thenReturn(filterDto);
        when(userServicePort.findByFilters(filterDto, paginator)).thenReturn(servicePaginateResponse);
        when(userMapper.toResponseFilter(servicePaginateResponse)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<ResponsePaginateDto<UserResponseDto>> response = userController.findByFilter(filterRequestDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
        verify(userMapper).toDto(userRequestDto);
        verify(userServicePort).findByFilters(filterDto, paginator);
        verify(userMapper).toResponseFilter(servicePaginateResponse);
    }
}