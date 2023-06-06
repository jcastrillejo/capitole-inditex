package com.capitole.inditex.infrastructure.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name = "H_PRICES",
    indexes = {@Index(name = "FK_CADENA_INDEX_6", columnList = "BRAND_ID")})
public class HPriceEntity {
  @Id
  @Column(name = "PRICE_LIST", nullable = false)
  private Integer hPricesId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "BRAND_ID", nullable = false)
  private BrandEntity brand;

  @Column(name = "START_DATE", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "END_DATE", nullable = false)
  private LocalDateTime endDate;

  @Column(name = "PRODUCT_ID", nullable = false)
  private Integer productId;

  @Column(name = "PRIORITY", nullable = false)
  private Integer priority;

  @Column(name = "PRICE", nullable = false)
  private Double price;

  @Column(name = "CURR", nullable = false, length = 3)
  private String curr;

  public String getCurr() {
    return curr;
  }

  public void setCurr(String curr) {
    this.curr = curr;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public BrandEntity getBrand() {
    return brand;
  }

  public void setBrand(BrandEntity brand) {
    this.brand = brand;
  }

  public Integer getId() {
    return hPricesId;
  }

  public void setId(Integer id) {
    this.hPricesId = id;
  }
}
