package com.testiniditex.infrastructure.repository.mapper;

import com.testiniditex.domain.model.Product;
import com.testiniditex.infrastructure.repository.entity.ProductEntity;
import com.testiniditex.infrastructure.repository.entity.ProductStockEntity;
import com.testiniditex.infrastructure.repository.entity.ProductStockId;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductEntityMapperTest {

    private final ProductEntityMapper mapper = Mappers.getMapper(ProductEntityMapper.class);

    @Test
    void testToDomain() {
        // Arrange
        ProductStockEntity stockEntity1 = new ProductStockEntity();
        stockEntity1.setId(new ProductStockId(1, "S"));
        stockEntity1.setQuantity(10);

        ProductStockEntity stockEntity2 = new ProductStockEntity();
        stockEntity2.setId(new ProductStockId(1, "M"));
        stockEntity2.setQuantity(5);

        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(1);
        productEntity.setName("Product A");
        productEntity.setSalesUnits(100);
        productEntity.setStock(List.of(stockEntity1, stockEntity2));

        // Act
        Product product = mapper.toDomain(productEntity);

        // Assert
        assertEquals(1, product.getId());
        assertEquals("Product A", product.getName());
        assertEquals(100, product.getSalesUnits());
        assertEquals(Map.of("S", 10, "M", 5), product.getStockBySize());
    }

    @Test
    void testMapStockEntityToMap() {
        // Arrange
        ProductStockEntity stockEntity1 = new ProductStockEntity();
        stockEntity1.setId(new ProductStockId(1, "S"));
        stockEntity1.setQuantity(10);

        ProductStockEntity stockEntity2 = new ProductStockEntity();
        stockEntity2.setId(new ProductStockId(1, "M"));
        stockEntity2.setQuantity(5);

        List<ProductStockEntity> stockEntities = List.of(stockEntity1, stockEntity2);

        // Act
        Map<String, Integer> stockMap = mapper.mapStockEntityToMap(stockEntities);

        // Assert
        assertEquals(2, stockMap.size());
        assertEquals(10, stockMap.get("S"));
        assertEquals(5, stockMap.get("M"));
    }

}