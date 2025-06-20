package edu.bo.uyunicode.template.admin.infrastructure.output.persistence;

import edu.bo.uyunicode.template.admin.application.output.IUserPersistencePort;
import edu.bo.uyunicode.template.admin.domain.dto.UserDto;
import edu.bo.uyunicode.template.admin.domain.models.PaginatedDataDto;
import edu.bo.uyunicode.template.admin.domain.models.PaginationDto;
import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.entity.UserEntity;
import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.mapper.IUserPersistenceMapper;
import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adapter class for user persistence in database
 */
@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserPersistenceMapper userMapper;

    /**
     * get a user's data by ID
     *
     * @param id user unique identifier
     * @return user info
     */
    @Override
    public Optional<UserDto> findById(Integer id) {
        return this.userRepository.findById(id)
                .map(this.userMapper::toDto);
    }

    /**
     * Save a user's changes
     *
     * @param dto user info
     * @return user updated
     */
    @Override
    public UserDto save(UserDto dto) {
        UserEntity entity = this.userMapper.toEntity(dto);
        entity = this.userRepository.save(entity);
        return this.userMapper.toDto(entity);
    }

    /**
     * Gets a list of users with pagination
     *
     * @param dto       user fields
     * @param paginator pagination data
     * @return users with pagination num
     */
    @Override
    public PaginatedDataDto<UserDto> findByFilter(UserDto dto, PaginationDto paginator) {
        Pageable pageable = PageRequest.of(paginator.pageNumber(), paginator.pageSize(), Sort.by(paginator.direction(), paginator.property()));
        Page<UserEntity> usersPage = this.userRepository.findAllByFilters(dto.userId(), dto.nickname(), dto.username(), dto.password(), dto.isEnabled(), pageable);
        List<UserDto> usersDtoPage = this.userMapper.toDtos(usersPage.getContent());
        return new PaginatedDataDto<>(usersDtoPage, 0, 0, 0, 0L);
    }
}
