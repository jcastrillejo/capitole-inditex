package com.capitole.inditex.infrastructure.input.rest.mapper;

import com.capitole.inditex.domain.model.HPrice;
import com.capitole.inditex.infrastructure.input.rest.data.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesRestAdapterMapper {

  @Mapping(target = "pricelistApplying", source = "id")
  @Mapping(target = "brandId", source = "brand.brandId")
  @Mapping(target = "startdateApplying", source = "startDate")
  @Mapping(target = "enddateApplying", source = "endDate")
  @Mapping(target = "priceApplying", source = "price")
  PriceDto toPriceDto(HPrice hPrice);

}
