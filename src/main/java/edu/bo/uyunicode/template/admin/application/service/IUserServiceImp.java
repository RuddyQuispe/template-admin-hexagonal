package edu.bo.uyunicode.template.admin.application.service;

import edu.bo.uyunicode.template.admin.application.input.IUserServicePort;
import edu.bo.uyunicode.template.admin.application.output.IUserPersistencePort;
import edu.bo.uyunicode.template.admin.domain.dto.UserDto;
import edu.bo.uyunicode.template.admin.domain.exceptions.UserNotFoundException;
import edu.bo.uyunicode.template.admin.domain.models.RequestPaginator;
import edu.bo.uyunicode.template.admin.domain.models.ResponsePaginateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IUserServiceImp implements IUserServicePort {

    private final IUserPersistencePort persistencePort;

    @Override
    public Optional<UserDto> findById(Integer id) {
        return this.persistencePort.findById(id);
    }

    @Override
    public UserDto save(UserDto dto) {
        return this.persistencePort.save(dto);
    }

    @Override
    public UserDto update(Integer id, UserDto dto) {
        return this.persistencePort.findById(id)
                .map(u -> {
                    UserDto userUpdated = new UserDto(dto.userId(), dto.nickname(), dto.username(), dto.password(), dto.isEnabled());
                    return this.persistencePort.save(userUpdated);
                })
                .orElseThrow(() -> new UserNotFoundException("Usuario %s no existe para ser modificado".formatted(id)));
    }

    @Override
    public ResponsePaginateDto<UserDto> findByFilters(UserDto filters, RequestPaginator requestFilter) {
        return this.persistencePort.findByFilter(filters, requestFilter);
    }
}
