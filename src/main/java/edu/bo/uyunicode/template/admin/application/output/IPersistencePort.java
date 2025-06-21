package edu.bo.uyunicode.template.admin.application.output;

import edu.bo.uyunicode.template.admin.domain.models.PaginatedDataDto;
import edu.bo.uyunicode.template.admin.domain.models.PaginationDto;

import java.util.Optional;

/**
 * interface standard for ABM objects
 *
 * @param <T> Id object
 * @param <K> DTO object
 */
public interface IPersistencePort<T, K> {
    Optional<T> findById(K id);

    T save(T dto);

    PaginatedDataDto<T> findByFilter(T dto, PaginationDto paginator);
}
