package com.capitole.inditex.infrastructure.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BRAND")
public class BrandEntity {
  @Id
  @Column(name = "BRAND_ID", nullable = false)
  private Integer brandId;

  @Column(name = "BRAND_NAME", nullable = false)
  private String brandName;

  @OneToMany(mappedBy = "brand")
  private Set<HPriceEntity> hPrices = new LinkedHashSet<>();

  public Set<HPriceEntity> getHPrices() {
    return hPrices;
  }

  public void setHPrices(Set<HPriceEntity> hPrices) {
    this.hPrices = hPrices;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public Integer getBrandId() {
    return brandId;
  }

  public void setBrandId(Integer brandId) {
    this.brandId = brandId;
  }
}
