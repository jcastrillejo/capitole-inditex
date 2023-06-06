package com.capitole.inditex.application.ports.output;

import com.capitole.inditex.domain.model.HPrice;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface HPriceOutputPort {
  List<HPrice> getHPricesBy(LocalDateTime applyingDate, BigDecimal productId, BigDecimal brandId);
}
