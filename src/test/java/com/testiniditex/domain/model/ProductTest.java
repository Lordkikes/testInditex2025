package com.testiniditex.domain.model;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    @Test
    void testGetStockRatioWithValidStock() {
        // Arrange
        Map<String, Integer> stockBySize = Map.of("S", 4, "M", 0, "L", 3);
        Product product = new Product(1, "Product A", 100, stockBySize);

        // Act
        double stockRatio = product.getStockRatio();

        // Assert
        assertEquals(0.66, stockRatio, 0.01);
    }

    @Test
    void testGetStockRatioWithEmptyStock() {
        // Arrange
        Map<String, Integer> stockBySize = Map.of();
        Product product = new Product(2, "Product B", 50, stockBySize);

        // Act
        double stockRatio = product.getStockRatio();

        // Assert
        assertEquals(0.0, stockRatio);
    }

    @Test
    void testGetStockRatioWithNullStock() {
        // Arrange
        Product product = new Product(3, "Product C", 30, null);

        // Act
        double stockRatio = product.getStockRatio();

        // Assert
        assertEquals(0.0, stockRatio);
    }
}