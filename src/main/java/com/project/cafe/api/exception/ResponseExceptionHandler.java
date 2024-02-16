package com.project.cafe.api.exception;

import com.project.cafe.api.exception.imp.ExceptionResponse;
import com.project.cafe.api.exception.imp.ModelNotFoundException;
import com.project.cafe.api.util.ConstantsMessages;
import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> manejarTodasExcepciones(
    Exception ex,
    WebRequest request
  ) {
    String message = ex
        .getMessage()
        .toUpperCase()
        .contains(ConstantsMessages.ERROR_NO_ENTITY_ON_DB.toUpperCase())
      ? ConstantsMessages.ERROR_NO_DATA
      : ex.getMessage();
    ExceptionResponse exceptionResponse = new ExceptionResponse(
      new Date(),
      message,
      request.getDescription(true)
    );

    return new ResponseEntity<>(
      exceptionResponse,
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }

  @ExceptionHandler(ModelNotFoundException.class)
  public final ResponseEntity<Object> manejarModeloExcepciones(
    ModelNotFoundException ex,
    WebRequest request
  ) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(
      new Date(),
      ex.getMessage(),
      request.getDescription(false)
    );

    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex,
    HttpHeaders headers,
    HttpStatus status,
    WebRequest request
  ) {
    StringBuilder errors = new StringBuilder();
    for (ObjectError e : ex.getBindingResult().getAllErrors()) {
      errors.append(e.getObjectName());
    }

    ExceptionResponse exceptionResponse = new ExceptionResponse(
      new Date(),
      ConstantsMessages.ERROR_ARGUMENT_NOT_VALID,
      errors.toString()
    );

    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
