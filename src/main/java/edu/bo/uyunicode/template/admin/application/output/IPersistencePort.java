package edu.bo.uyunicode.template.admin.application.output;

import edu.bo.uyunicode.template.admin.domain.models.RequestPaginator;
import edu.bo.uyunicode.template.admin.domain.models.ResponsePaginateDto;

import java.util.Optional;

/**
 * interface standard for ABM objects
 *
 * @param <T> Id object
 * @param <K> DTO object
 */
public interface IPersistencePort<T, K> {
    Optional<K> findById(T id);

    K save(K dto);

    ResponsePaginateDto<K> findByFilter(K dto, RequestPaginator paginator);
}
