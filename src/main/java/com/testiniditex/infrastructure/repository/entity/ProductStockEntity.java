package com.testiniditex.infrastructure.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_stock")
@Getter
@Setter
@NoArgsConstructor
public class ProductStockEntity {

    @EmbeddedId
    private ProductStockId id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
