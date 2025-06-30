package com.testiniditex.infrastructure.repository.mapper;

import com.testiniditex.domain.model.Product;
import com.testiniditex.infrastructure.repository.entity.ProductEntity;

import com.testiniditex.infrastructure.repository.entity.ProductStockEntity;
import com.testiniditex.infrastructure.repository.entity.ProductStockId;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    @Mapping(target = "stockBySize", source = "stock")
    Product toDomain(ProductEntity entity);

    @InheritInverseConfiguration
    @Mapping(target = "stock", source = "stockBySize")
    ProductEntity toEntity(Product product);

    // Mapea de List<ProductStockEntity> a Map<String, Integer>
    default Map<String, Integer> mapStockEntityToMap(List<ProductStockEntity> stockEntities) {
        if (stockEntities == null) return Collections.emptyMap();
        return stockEntities.stream()
                .collect(Collectors.toMap(
                        e -> e.getId().getSize(),
                        ProductStockEntity::getQuantity));
    }

    // Mapea de Map<String, Integer> a List<ProductStockEntity>
    default List<ProductStockEntity> mapStockMapToEntities(Map<String, Integer> stockMap) {
        if (stockMap == null) return Collections.emptyList();
        return stockMap.entrySet().stream()
                .map(entry -> {
                    ProductStockEntity stockEntity = new ProductStockEntity();
                    stockEntity.setId(new ProductStockId(null, entry.getKey()));
                    stockEntity.setQuantity(entry.getValue());
                    return stockEntity;
                })
                .collect(Collectors.toList());
    }
}