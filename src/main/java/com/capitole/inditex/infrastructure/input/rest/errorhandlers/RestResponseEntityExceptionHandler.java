package com.capitole.inditex.infrastructure.input.rest.errorhandlers;

import com.capitole.inditex.domain.exception.PriceNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = {IllegalArgumentException.class, TypeMismatchException.class})
  protected ResponseEntity<ErrorDto> handleArgumentErrorException(RuntimeException ex) {
    return new ResponseEntity<>(
        ErrorDto.builder()
            .responseCode("001")
            .responseMessage("Parameters error: " + ex.getCause().getLocalizedMessage())
            .build(),
        HttpStatus.BAD_REQUEST);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = {PriceNotFoundException.class})
  protected ResponseEntity<ErrorDto> handlePriceNotFoundException(RuntimeException ex) {
    return new ResponseEntity<>(
        ErrorDto.builder()
            .responseCode(PriceNotFoundException.ERROR_CODE)
            .responseMessage(PriceNotFoundException.ERROR_MESSAGE)
            .build(),
        HttpStatus.BAD_REQUEST);
  }
}
