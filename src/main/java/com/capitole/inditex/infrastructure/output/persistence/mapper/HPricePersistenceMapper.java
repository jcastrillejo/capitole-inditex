package com.capitole.inditex.infrastructure.output.persistence.mapper;

import com.capitole.inditex.domain.model.HPrice;
import com.capitole.inditex.infrastructure.output.persistence.entity.HPriceEntity;
import org.mapstruct.Mapper;

@Mapper
public interface HPricePersistenceMapper {
  HPriceEntity toHPriceEntity(HPrice hPrice);

  HPrice toHPrice(HPriceEntity hPriceEntity);
}
