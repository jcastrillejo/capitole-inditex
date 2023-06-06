package com.capitole.inditex.infrastructure.input.rest.errorhandlers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ErrorDto {
  @JsonProperty("response_code")
  private String responseCode;

  @JsonProperty("response_message")
  private String responseMessage;
}
