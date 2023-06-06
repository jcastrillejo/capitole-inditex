package com.capitole.inditex.infrastructure.output.persistence;

import com.capitole.inditex.domain.model.Brand;
import com.capitole.inditex.domain.model.HPrice;
import com.capitole.inditex.infrastructure.output.persistence.entity.BrandEntity;
import com.capitole.inditex.infrastructure.output.persistence.entity.HPriceEntity;
import com.capitole.inditex.infrastructure.output.persistence.mapper.HPricePersistenceMapper;
import com.capitole.inditex.infrastructure.output.persistence.repository.HPriceRepository;
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
class HPricePersistenceAdapterTest {

  @Mock private HPriceRepository hPriceRepository;

  @Mock private HPricePersistenceMapper hPricePersistenceMapper;

  @InjectMocks private HPricePersistenceAdapter hPricePersistenceAdapter;

  LocalDateTime today, correctDate;
  HPriceEntity hPriceEntity1, hPriceEntity2;
  HPrice hPrice1, hPrice2;

  @BeforeEach
  void setUp() {
    today = LocalDateTime.now();
    correctDate = LocalDateTime.of(2020, 6, 14, 16, 0, 0);

    hPriceEntity1 =
        new HPriceEntity(
            1,
            new BrandEntity(1, "Zara", Collections.emptySet()),
            LocalDateTime.of(2020, 6, 14, 0, 0, 0),
            LocalDateTime.of(2020, 12, 31, 23, 59, 59),
            35455,
            0,
            35.50,
            "EUR");
    hPriceEntity2 =
        new HPriceEntity(
            1,
            new BrandEntity(1, "Zara", Collections.emptySet()),
            LocalDateTime.of(2020, 6, 14, 15, 0, 0),
            LocalDateTime.of(2020, 6, 15, 18, 30, 0),
            35455,
            1,
            25.45,
            "EUR");

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
  void getHPricesBy_Test_No_Database_Result() {
    Mockito.when(
            hPriceRepository.getHPricesEntityBy(today, BigDecimal.valueOf(35455), BigDecimal.ONE))
        .thenReturn(Collections.emptyList());
    assertEquals(
        hPricePersistenceAdapter.getHPricesBy(today, BigDecimal.valueOf(35455), BigDecimal.ONE),
        Collections.emptyList());
  }

  @Test
  void getHPricesBy_Test_Ok() {
    Mockito.when(
            hPriceRepository.getHPricesEntityBy(
                correctDate, BigDecimal.valueOf(35455), BigDecimal.ONE))
        .thenReturn(new ArrayList<>(Arrays.asList(hPriceEntity1, hPriceEntity2)));
    Mockito.when(hPricePersistenceMapper.toHPrice(hPriceEntity1)).thenReturn(hPrice1);
    Mockito.when(hPricePersistenceMapper.toHPrice(hPriceEntity2)).thenReturn(hPrice2);

    assertEquals(
        hPricePersistenceAdapter.getHPricesBy(
            correctDate, BigDecimal.valueOf(35455), BigDecimal.ONE),
        new ArrayList<>(Arrays.asList(hPrice1, hPrice2)));
  }
}
