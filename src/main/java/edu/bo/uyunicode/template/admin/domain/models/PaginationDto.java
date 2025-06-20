package edu.bo.uyunicode.template.admin.domain.models;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Sort.Direction;

import java.io.Serializable;

public record PaginationDto(
        @NotNull(message = "direction requerido")
        Direction direction,
        @NotNull(message = "property requerido")
        String property,
        @NotNull(message = "pageNumber requerido")
        Integer pageNumber,
        @NotNull(message = "pageSize requerido")
        Integer pageSize) implements Serializable {
}