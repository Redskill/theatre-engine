package com.fabio.theatre.theatreengine.exceptions.handlers

import com.fabio.theatre.theatreengine.errors.LoginFailedErrorResponse
import com.fabio.theatre.theatreengine.exceptions.LoginNotValidException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class CustomerExceptionHandler {

  @ExceptionHandler
  fun handleException(exception: LoginNotValidException) : ResponseEntity<LoginFailedErrorResponse> {
    var error = LoginFailedErrorResponse(
        HttpStatus.FORBIDDEN.value(),
        exception.message,
        System.currentTimeMillis())

    return ResponseEntity(error, HttpStatus.FORBIDDEN)
  }
}