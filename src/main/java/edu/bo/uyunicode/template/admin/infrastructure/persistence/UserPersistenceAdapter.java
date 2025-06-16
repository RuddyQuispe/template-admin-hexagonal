package edu.bo.uyunicode.template.admin.infrastructure.persistence;

import edu.bo.uyunicode.template.admin.application.output.IUserPersistencePort;
import edu.bo.uyunicode.template.admin.domain.dto.UserDto;
import edu.bo.uyunicode.template.admin.domain.entity.UserEntity;
import edu.bo.uyunicode.template.admin.domain.mappers.IUserMapper;
import edu.bo.uyunicode.template.admin.domain.models.RequestPaginator;
import edu.bo.uyunicode.template.admin.domain.models.ResponsePaginateDto;
import edu.bo.uyunicode.template.admin.infrastructure.persistence.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserMapper userMapper;

    @Override
    public Optional<UserDto> findById(Integer id) {
        return this.userRepository.findById(id)
                .map(this.userMapper::toDto);
    }

    @Override
    public UserDto save(UserDto dto) {
        UserEntity entity = this.userMapper.toEntity(dto);
        entity = this.userRepository.save(entity);
        return this.userMapper.toDto(entity);
    }

    @Override
    public ResponsePaginateDto<UserDto> findByFilter(UserDto dto, RequestPaginator paginator) {
        Pageable pageable = PageRequest.of(paginator.pageNumber(), paginator.pageSize(), Sort.by(paginator.direction(), paginator.property()));
        return new ResponsePaginateDto<>(List.of(), 0, 0, 0, 0L);
    }


}
