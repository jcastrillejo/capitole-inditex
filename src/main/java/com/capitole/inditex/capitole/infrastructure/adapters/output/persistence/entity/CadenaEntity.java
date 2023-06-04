package com.capitole.inditex.capitole.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CADENA")
public class CadenaEntity {
    @Id @Column(name = "BRAND_ID", nullable = false) private Integer id;

    @Column(name = "CADENA", nullable = false) private String cadena;

    @OneToMany(mappedBy = "brand") private Set<HPriceEntity> hPrices = new LinkedHashSet<>();

    public Set<HPriceEntity> getHPrices() {
        return hPrices;
    }

    public void setHPrices(Set<HPriceEntity> hPrices) {
        this.hPrices = hPrices;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}