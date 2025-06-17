package edu.bo.uyunicode.template.admin.domain.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record ExceptionResponseDto(
        LocalDateTime timestamp,
        String message,
        List<String> detail) implements Serializable {
}
