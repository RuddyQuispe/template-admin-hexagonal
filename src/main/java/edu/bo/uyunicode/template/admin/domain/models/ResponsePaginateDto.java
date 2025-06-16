package edu.bo.uyunicode.template.admin.domain.models;

import java.io.Serializable;
import java.util.List;

public record ResponsePaginateDto<T>(
        List<T> data,
        Integer pageNo,
        Integer size,
        Integer totalPages,
        Long totalElements) implements Serializable {
}
