package edu.bo.uyunicode.template.admin.domain.dto.request;

import edu.bo.uyunicode.template.admin.domain.models.RequestPaginator;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record UserFilterRequestDto(
        @NotNull(message = "filter requerido")
        UserRequestDto filter,
        @NotNull(message = "pagination requerido")
        RequestPaginator pagination) implements Serializable {

}
