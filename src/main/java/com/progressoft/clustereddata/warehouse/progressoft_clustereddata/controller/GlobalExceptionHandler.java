package com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller;

import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller.response.BindExceptionResponse;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller.response.ExceptionResponse;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.controller.response.ViolationExceptionResponse;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.exception.DealDetailNotFoundException;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.exception.ViolationException;
import com.progressoft.clustereddata.warehouse.progressoft_clustereddata.model.Violation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<BindExceptionResponse>> bindExceptionError(BindException bindException) {
        List<BindExceptionResponse> exceptions = bindException.getFieldErrors()
                .stream()
                .map(error -> new BindExceptionResponse(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exceptions);
    }

    @ExceptionHandler(DealDetailNotFoundException.class)
    public ResponseEntity<ExceptionResponse> dealDetailNotFoundExceptionHandler(DealDetailNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(ViolationException.class)
    public ResponseEntity<ViolationExceptionResponse> violationException(ViolationException exception) {
        Map<String, String> violations = exception.getViolations().stream()
                .collect(Collectors.toMap(Violation::getViolationName, Violation::getViolationMessage));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ViolationExceptionResponse(violations));
    }


}
