package com.testiniditex.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "sales_units", nullable = false)
    private int salesUnits;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductStockEntity> stock;
}