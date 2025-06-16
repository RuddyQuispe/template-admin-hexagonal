package edu.bo.uyunicode.template.admin.domain.dto.request;

import edu.bo.uyunicode.template.admin.domain.models.RequestPaginator;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Schema(description = "filters for get users")
public record UserFilterRequestDto(
        @NotNull(message = "filter requerido")
        UserRequestDto filter,
        @Valid
        @NotNull(message = "pagination requerido")
        RequestPaginator pagination) implements Serializable {

}
