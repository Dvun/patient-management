package com.pm.patientservice.exception;

import com.pm.patientservice.utils.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream().filter(fe -> fe.getDefaultMessage() != null)
                .collect(Collectors.toMap(FieldError::getField,
                        FieldError::getDefaultMessage,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));


        ApiResponse<Object> body = ApiResponse.failure(
                HttpStatus.BAD_REQUEST,
                errors,
                null,
                request.getRequestURI()
        );

        return ResponseEntity.status(body.getStatus()).body(body);
    }


    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> handleEmailException(EmailAlreadyExistsException ex, HttpServletRequest request) {
        log.error(ex.getMessage());
        ApiResponse<Object> body = ApiResponse.failure(
                HttpStatus.CONFLICT,
                new HashMap<>(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(body.getStatus()).body(body);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> notFoundException(NotFoundException ex, HttpServletRequest request) {
        log.error(ex.getMessage());
        ApiResponse<Object> body = ApiResponse.failure(
                HttpStatus.CONFLICT,
                new HashMap<>(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(body.getStatus()).body(body);
    }

}
