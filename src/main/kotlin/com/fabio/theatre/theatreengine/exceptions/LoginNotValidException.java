package com.fabio.theatre.theatreengine.exceptions;

public class LoginNotValidException extends RuntimeException {

  public LoginNotValidException() {
  }

  public LoginNotValidException(String message) {
    super(message);
  }

  public LoginNotValidException(String message, Throwable cause) {
    super(message, cause);
  }

  public LoginNotValidException(Throwable cause) {
    super(cause);
  }

  public LoginNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
