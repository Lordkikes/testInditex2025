
package com.testiniditex.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
@Setter
@AllArgsConstructor
public class Product {

    private final int id;
    private final String name;
    private final int salesUnits;
    private final Map<String, Integer> stockBySize;

    /**
     * Calcula el ratio de stock como la fracción de tallas que tienen stock disponible.
     * Ejemplo: S:4, M:0, L:3 => 2/3 = 0.66
     *
     * @return ratio entre tallas con stock y total de tallas
     */
    public double getStockRatio() {
        if (stockBySize == null || stockBySize.isEmpty()) {
            return 0.0;
        }
        long totalTallas = stockBySize.size();
        long conStock = stockBySize.values().stream()
                .filter(cantidad -> cantidad > 0)
                .count();
        return (double) conStock / totalTallas;
    }
}