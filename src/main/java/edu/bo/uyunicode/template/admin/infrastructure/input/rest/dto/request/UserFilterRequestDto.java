package edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.request;

import edu.bo.uyunicode.template.admin.domain.models.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Schema(description = "filters for get users")
public record UserFilterRequestDto(
        @Valid
        @NotNull(message = "filter requerido")
        UserFilterDto filter,
        @Valid
        @NotNull(message = "pagination requerido")
        PaginationDto pagination) implements Serializable {

}
