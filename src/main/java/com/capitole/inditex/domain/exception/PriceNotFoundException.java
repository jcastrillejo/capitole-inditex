package com.capitole.inditex.domain.exception;

public class PriceNotFoundException extends RuntimeException {
  public static final String ERROR_CODE = "002";
  public static final String ERROR_MESSAGE = "There are no results for the provided parameters.";

  public PriceNotFoundException() {
    super(ERROR_MESSAGE);
  }
}
