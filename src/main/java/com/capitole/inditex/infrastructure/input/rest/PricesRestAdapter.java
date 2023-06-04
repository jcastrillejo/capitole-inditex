package com.capitole.inditex.infrastructure.input.rest;

import com.capitole.inditex.infrastructure.input.rest.data.PriceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
public class PricesRestAdapter implements PricesApi {
  @Override
  public ResponseEntity<PriceDto> _getPriceFromDate(
      OffsetDateTime applyingDate, BigDecimal productId, BigDecimal brandId) {
    return ResponseEntity.ok().body(new PriceDto());
  }
}
