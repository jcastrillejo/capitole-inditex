package com.capitole.inditex.domain.service;

import com.capitole.inditex.application.ports.input.PriceApplyingUseCase;
import com.capitole.inditex.application.ports.output.HPriceOutputPort;
import com.capitole.inditex.domain.exception.PriceNotFoundException;
import com.capitole.inditex.domain.model.HPrice;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PriceApplyingService implements PriceApplyingUseCase {

  private final HPriceOutputPort hPriceOutputPort;

  @Override
  public HPrice getPriceApplying(OffsetDateTime applyingDate, BigDecimal productId,
      BigDecimal brandId) {
    List<HPrice> hPrices = hPriceOutputPort.getHPricesBy(applyingDate, productId, brandId);
    if(hPrices.isEmpty()) {
      throw new PriceNotFoundException();
    }
    return hPrices.stream().max(Comparator.comparingInt(HPrice::getPriority)).orElse(null);
  }
}
