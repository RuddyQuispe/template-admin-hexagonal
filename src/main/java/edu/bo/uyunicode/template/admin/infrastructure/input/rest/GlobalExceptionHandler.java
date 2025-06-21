package edu.bo.uyunicode.template.admin.infrastructure.input.rest;

import edu.bo.uyunicode.template.admin.infrastructure.input.rest.dto.ExceptionResponseDto;
import edu.bo.uyunicode.template.admin.domain.exceptions.ModelNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleModelNotFoundException(ModelNotFoundException e, WebRequest request) {
        ExceptionResponseDto error = new ExceptionResponseDto(LocalDateTime.now(), e.getMessage(), null);
        log.error("ModelNotFoundException :{0} ", new Object[]{error});
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ExceptionResponseDto> handleSQLException(SQLException e, WebRequest wr) {
        ExceptionResponseDto error = new ExceptionResponseDto(LocalDateTime.now(), e.getMessage(), null);
        log.error("SQLException :{0} ", new Object[]{error});
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ExceptionResponseDto> handleUnsupportedOperationException(Exception e, WebRequest wr) {
        ExceptionResponseDto error = new ExceptionResponseDto(LocalDateTime.now(), e.getMessage(), null);
        log.error("UnsupportedOperationException :{0} ", new Object[]{error});
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidExceptionHandler :{0} ", new Object[]{ex.getMessage()});
        List<String> errorValidation = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> errorValidation.add(error.getDefaultMessage()));
        ExceptionResponseDto error = new ExceptionResponseDto(LocalDateTime.now(), "Error request validación.", errorValidation);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
