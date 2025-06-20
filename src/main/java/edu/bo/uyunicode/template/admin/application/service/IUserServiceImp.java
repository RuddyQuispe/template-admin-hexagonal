package edu.bo.uyunicode.template.admin.application.service;

import edu.bo.uyunicode.template.admin.application.input.IUserServicePort;
import edu.bo.uyunicode.template.admin.application.output.IUserPersistencePort;
import edu.bo.uyunicode.template.admin.domain.dto.UserDto;
import edu.bo.uyunicode.template.admin.domain.exceptions.UserNotFoundException;
import edu.bo.uyunicode.template.admin.domain.models.PaginatedDataDto;
import edu.bo.uyunicode.template.admin.domain.models.PaginationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * business model implementation class (incoming port)
 */
@Service
@RequiredArgsConstructor
public class IUserServiceImp implements IUserServicePort {

    private final IUserPersistencePort persistencePort;

    /**
     * method to obtain user data by ID
     *
     * @param id unique user identifier (userId)
     * @return user data, if not exists return Optional.empty()
     */
    @Override
    public Optional<UserDto> findById(Integer id) {
        return this.persistencePort.findById(id);
    }

    /**
     * save new user
     *
     * @param dto new user data
     * @return user created
     */
    @Override
    public UserDto save(UserDto dto) {
        return this.persistencePort.save(dto);
    }

    /**
     * update user data
     *
     * @param id  unique user identifier (userId)
     * @param dto new data of user
     * @return user updated
     */
    @Override
    public UserDto update(Integer id, UserDto dto) {
        return this.persistencePort.findById(id)
                .map(u -> {
                    UserDto userUpdated = new UserDto(dto.userId(), dto.nickname(), dto.username(), dto.password(), dto.isEnabled());
                    return this.persistencePort.save(userUpdated);
                })
                .orElseThrow(() -> new UserNotFoundException("Usuario %s no existe para ser modificado ".formatted(id)));
    }

    /**
     * get users per page
     *
     * @param filters   user filters
     * @param paginator pagination info
     * @return list of users with page data
     */
    @Override
    public PaginatedDataDto<UserDto> findByFilters(UserDto filters, PaginationDto paginator) {
        return this.persistencePort.findByFilter(filters, paginator);
    }
}
