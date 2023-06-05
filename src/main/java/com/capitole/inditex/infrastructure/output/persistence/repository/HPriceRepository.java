package com.capitole.inditex.infrastructure.output.persistence.repository;

import com.capitole.inditex.infrastructure.output.persistence.entity.HPriceEntity;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HPriceRepository extends JpaRepository<HPriceEntity, Integer> {
  @Query(
      value =
          "select hprice from HPriceEntity hprice where hprice.productId = :productId and hprice.brand.brandId = :brandId and :applyingDate between hprice.startDate and hprice.endDate")
  List<HPriceEntity> getHPricesEntityBy(
      Instant applyingDate, BigDecimal productId, BigDecimal brandId);
}
