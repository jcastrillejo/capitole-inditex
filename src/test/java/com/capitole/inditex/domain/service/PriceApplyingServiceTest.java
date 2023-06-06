package com.capitole.inditex.domain.service;

import com.capitole.inditex.application.ports.output.HPriceOutputPort;
import com.capitole.inditex.domain.exception.PriceNotFoundException;
import com.capitole.inditex.domain.model.Brand;
import com.capitole.inditex.domain.model.HPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PriceApplyingServiceTest {

  @Mock private HPriceOutputPort hPriceOutputPort;

  @InjectMocks private PriceApplyingService priceApplyingService;

  LocalDateTime today, correctDate;
  HPrice hPrice1, hPrice2;

  @BeforeEach
  void setUp() {
    today = LocalDateTime.now();
    correctDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
    hPrice1 =
        HPrice.builder()
            .brand(Brand.builder().brandId(1).brandName("Zara").build())
            .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
            .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
            .id(1)
            .productId(35455)
            .priority(0)
            .price(35.50)
            .curr("EUR")
            .build();
    hPrice2 =
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
  void getPriceApplying_Test_No_Result_Database_Exception() {
    Mockito.when(hPriceOutputPort.getHPricesBy(today, BigDecimal.valueOf(35455), BigDecimal.ONE))
        .thenReturn(Collections.emptyList());
    assertThrows(
        PriceNotFoundException.class,
        () ->
            priceApplyingService.getPriceApplying(
                today, BigDecimal.valueOf(35455), BigDecimal.ONE));
  }

  @Test
  void getPriceApplying_Test_Ok() {
    Mockito.when(
            hPriceOutputPort.getHPricesBy(correctDate, BigDecimal.valueOf(35455), BigDecimal.ONE))
        .thenReturn(new ArrayList<>(Arrays.asList(hPrice1, hPrice2)));
    assertEquals(
        priceApplyingService.getPriceApplying(
            correctDate, BigDecimal.valueOf(35455), BigDecimal.ONE),
        hPrice2);
  }
}
