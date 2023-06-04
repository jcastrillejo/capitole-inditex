package com.capitole.inditex.infrastructure.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.LinkedHashSet;
import java.util.Set;

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

  public String getCadena() {
    return brandName;
  }

  public void setCadena(String cadena) {
    this.brandName = cadena;
  }

  public Integer getId() {
    return brandId;
  }

  public void setId(Integer id) {
    this.brandId = id;
  }
}
