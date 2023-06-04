package com.capitole.inditex.capitole.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "H_PRICES", indexes = { @Index(name = "FK_CADENA_INDEX_6", columnList = "BRAND_ID") })
public class HPriceEntity {
    @Id @Column(name = "PRICE_LIST", nullable = false) private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "BRAND_ID", nullable = false) private CadenaEntity brand;

    @Column(name = "START_DATE", nullable = false) private Instant startDate;

    @Column(name = "END_DATE", nullable = false) private Instant endDate;

    @Column(name = "PRODUCT_ID", nullable = false) private Integer productId;

    @Column(name = "PRIORITY", nullable = false) private Integer priority;

    @Column(name = "PRICE", nullable = false) private Double price;

    @Column(name = "CURR", nullable = false, length = 3) private String curr;

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

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public CadenaEntity getBrand() {
        return brand;
    }

    public void setBrand(CadenaEntity brand) {
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}