package edu.bo.uyunicode.template.admin.application.input;

import edu.bo.uyunicode.template.admin.domain.models.RequestPaginator;
import edu.bo.uyunicode.template.admin.domain.models.ResponsePaginateDto;

import java.util.List;
import java.util.Optional;

/**
 * service ports standard
 *
 * @param <T> Id Object
 * @param <K> DTO object
 */
public interface IServicePort<T, K> {
    Optional<K> findById(T id);

    K save(K dto);

    K update(T id, K dto);

    ResponsePaginateDto<K> findByFilters(K filters, RequestPaginator paginator);
}
