package com.blog.blog_app_api.exceptions;

import java.util.HashMap;
import java.util.Map;

import com.blog.blog_app_api.payloads.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExecptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resrourceNotFoundExceptionHandler(ResourceNotFoundException ex) {

        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);

        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
        // System.out.println("Exception message: " + ex.toString());
        Map<String, String> res = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // System.out.println("Error message: " + error.toString());
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            res.put(fieldName, message);
        });
        return new ResponseEntity<Map<String, String>>(res, HttpStatus.BAD_REQUEST);
    }
}
