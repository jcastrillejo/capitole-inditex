package com.capitole.inditex.application.ports.input;

import com.capitole.inditex.domain.model.HPrice;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface PriceApplyingUseCase {
  HPrice getPriceApplying(OffsetDateTime applyingDate, BigDecimal productId, BigDecimal brandId);
}
