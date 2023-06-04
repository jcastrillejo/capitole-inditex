package com.capitole.inditex.domain.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class HPrice {
  private Integer id;
  private Brand brand;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Integer productId;
  private Integer priority;
  private Double price;
  private String curr;

}