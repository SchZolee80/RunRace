package com.example.runrace.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Kivételkezelő a validációs hibákhoz.
     * Ha egy validációs hiba történik, ez a metódus kezeli azt, és visszaad egy HTTP 400 (Bad Request) választ a hibás mezőkkel.
     *
     * @param ex A MethodArgumentNotValidException, amely a validációs hibákat tartalmazza.
     * @return A validációs hibák és azok üzenetei egy ResponseEntity-ben.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Kivételkezelő a futásidejű hibákhoz.
     * Ha egy futásidejű hiba történik, ez a metódus kezeli azt, és visszaad egy HTTP 404 (Not Found) választ a hibaüzenettel.
     *
     * @param ex A RuntimeException, amely a futásidejű hibát tartalmazza.
     * @return A hibaüzenet egy ResponseEntity-ben.
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
