package edu.bo.uyunicode.template.admin.application.input;

import edu.bo.uyunicode.template.admin.domain.models.PaginationDto;
import edu.bo.uyunicode.template.admin.domain.models.PaginatedDataDto;

import java.util.Optional;

/**
 * service ports standard
 *
 * @param <K> Id Object
 * @param <T> DTO object
 */
public interface IServicePort<T, K> {
    Optional<T> findById(K id);

    T save(T dto);

    T update(K id, T dto);

    PaginatedDataDto<T> findByFilters(T filters, PaginationDto paginator);
}
