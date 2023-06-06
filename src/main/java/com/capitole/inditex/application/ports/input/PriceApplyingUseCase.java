package com.capitole.inditex.application.ports.input;

import com.capitole.inditex.domain.model.HPrice;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PriceApplyingUseCase {
  HPrice getPriceApplying(LocalDateTime applyingDate, BigDecimal productId, BigDecimal brandId);
}
