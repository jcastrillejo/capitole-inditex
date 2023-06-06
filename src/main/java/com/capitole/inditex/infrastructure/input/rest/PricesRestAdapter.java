package com.capitole.inditex.infrastructure.input.rest;

import com.capitole.inditex.application.ports.input.PriceApplyingUseCase;
import com.capitole.inditex.infrastructure.input.rest.data.PriceDto;
import com.capitole.inditex.infrastructure.input.rest.mapper.PricesRestAdapterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PricesRestAdapter implements PricesApi {

  private final PriceApplyingUseCase priceApplyingUseCase;
  private final PricesRestAdapterMapper pricesRestAdapterMapper;

  @Override
  public ResponseEntity<PriceDto> _getPriceFromDate(
      LocalDateTime applyingDate, BigDecimal productId, BigDecimal brandId) {
    return ResponseEntity.ok()
        .body(
            pricesRestAdapterMapper.toPriceDto(
                priceApplyingUseCase.getPriceApplying(applyingDate, productId, brandId)));
  }
}
