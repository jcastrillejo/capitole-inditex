package com.capitole.inditex.infrastructure.input.rest;

import com.capitole.inditex.application.ports.input.PriceApplyingUseCase;
import com.capitole.inditex.domain.exception.PriceNotFoundException;
import com.capitole.inditex.domain.model.Brand;
import com.capitole.inditex.domain.model.HPrice;
import com.capitole.inditex.infrastructure.input.rest.mapper.PricesRestAdapterMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PricesRestAdapterTest {

  @Mock private PriceApplyingUseCase priceApplyingUseCase;
  @Mock private PricesRestAdapterMapper pricesRestAdapterMapper;

  @InjectMocks private PricesRestAdapter pricesRestAdapter;

  LocalDateTime today, correctDate;
  HPrice hPrice;

  @BeforeEach
  void setUp() {
    today = LocalDateTime.now();
    correctDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
    hPrice =
        HPrice.builder()
            .brand(Brand.builder().brandId(1).brandName("Zara").build())
            .startDate(LocalDateTime.of(2020, 6, 14, 15, 0, 0))
            .endDate(LocalDateTime.of(2020, 6, 15, 18, 30, 0))
            .id(2)
            .productId(35455)
            .priority(1)
            .price(25.45)
            .curr("EUR")
            .build();
  }

  @Test
  void _getPriceFromDate_Test_No_Result_Database_Exception() {
    Mockito.when(
            priceApplyingUseCase.getPriceApplying(today, BigDecimal.valueOf(35455), BigDecimal.ONE))
        .thenThrow(PriceNotFoundException.class);
    assertThrows(
        PriceNotFoundException.class,
        () ->
            pricesRestAdapter._getPriceFromDate(today, BigDecimal.valueOf(35455), BigDecimal.ONE));
  }

  @Test
  void _getPriceFromDate_Test_Ok() {
    Mockito.when(
            priceApplyingUseCase.getPriceApplying(
                correctDate, BigDecimal.valueOf(35455), BigDecimal.ONE))
        .thenReturn(hPrice);
    assertEquals(
        pricesRestAdapter._getPriceFromDate(correctDate, BigDecimal.valueOf(35455), BigDecimal.ONE),
        ResponseEntity.ok().body(pricesRestAdapterMapper.toPriceDto(hPrice)));
  }
}
