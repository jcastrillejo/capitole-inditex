package com.capitole.inditex.infrastructure.input.rest;

import com.capitole.inditex.application.ports.input.PriceApplyingUseCase;
import com.capitole.inditex.domain.model.HPrice;
import com.capitole.inditex.infrastructure.input.rest.data.PriceDto;
import com.capitole.inditex.infrastructure.input.rest.mapper.PricesRestAdapterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@RestController
@RequiredArgsConstructor
public class PricesRestAdapter implements PricesApi {

  private final PriceApplyingUseCase priceApplyingUseCase;
  private final PricesRestAdapterMapper pricesRestAdapterMapper;

  @Override
  public ResponseEntity<PriceDto> _getPriceFromDate(
      OffsetDateTime applyingDate, BigDecimal productId, BigDecimal brandId) {
    return ResponseEntity.ok()
        .body(
            pricesRestAdapterMapper.toPriceDto(
                priceApplyingUseCase.getPriceApplying(applyingDate, productId, brandId)));
  }
}
