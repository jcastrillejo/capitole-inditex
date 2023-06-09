package com.capitole.inditex.infrastructure.output.persistence;

import com.capitole.inditex.application.ports.output.HPriceOutputPort;
import com.capitole.inditex.domain.model.HPrice;
import com.capitole.inditex.infrastructure.output.persistence.mapper.HPricePersistenceMapper;
import com.capitole.inditex.infrastructure.output.persistence.repository.HPriceRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HPricePersistenceAdapter implements HPriceOutputPort {

  private final HPriceRepository hPriceRepository;
  private final HPricePersistenceMapper hPricePersistenceMapper;

  @Override
  public List<HPrice> getHPricesBy(
      LocalDateTime applyingDate,
      BigDecimal productId,
      BigDecimal brandId) {
    return hPriceRepository.getHPricesEntityBy(applyingDate, productId, brandId).stream()
        .map(hPricePersistenceMapper::toHPrice)
        .toList();
  }
}
