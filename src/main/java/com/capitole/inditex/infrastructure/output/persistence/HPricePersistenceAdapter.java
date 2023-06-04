package com.capitole.inditex.infrastructure.output.persistence;

import com.capitole.inditex.application.ports.output.HPriceOutputPort;
import com.capitole.inditex.domain.model.HPrice;
import com.capitole.inditex.infrastructure.output.persistence.mapper.HPricePersistenceMapper;
import com.capitole.inditex.infrastructure.output.persistence.repository.HPriceRepository;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@RequiredArgsConstructor
public class HPricePersistenceAdapter implements HPriceOutputPort {

  private final HPriceRepository hPriceRepository;
  private final HPricePersistenceMapper hPricePersistenceMapper;

  @Override
  public List<HPrice> getHPricesBy(
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime applyingDate,
      BigDecimal productId,
      BigDecimal brandId) {
    return hPriceRepository.getHPricesEntityBy(applyingDate, productId, brandId).stream()
        .map(hPricePersistenceMapper::toHPrice)
        .toList();
  }
}
