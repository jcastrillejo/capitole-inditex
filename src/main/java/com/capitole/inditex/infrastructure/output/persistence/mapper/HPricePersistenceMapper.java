package com.capitole.inditex.infrastructure.output.persistence.mapper;

import com.capitole.inditex.domain.model.HPrice;
import com.capitole.inditex.infrastructure.output.persistence.entity.HPriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HPricePersistenceMapper {
  @Mapping(target = "startDate", expression = "java(hPrice.getStartDate().atZone(java.time.ZoneOffset.UTC).toInstant())")
  @Mapping(target = "endDate", expression = "java(hPrice.getEndDate().atZone(java.time.ZoneOffset.UTC).toInstant())")
  HPriceEntity toHPriceEntity(HPrice hPrice);

  @Mapping(target = "startDate", expression = "java(java.time.LocalDateTime.ofInstant(hPriceEntity.getStartDate(), java.time.ZoneOffset.UTC))")
  @Mapping(target = "endDate", expression = "java(java.time.LocalDateTime.ofInstant(hPriceEntity.getEndDate(), java.time.ZoneOffset.UTC))")
  HPrice toHPrice(HPriceEntity hPriceEntity);
}
