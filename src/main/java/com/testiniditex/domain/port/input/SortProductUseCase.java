package com.testiniditex.domain.port.input;

import com.testiniditex.domain.model.Product;

import java.util.List;

/**
 * Puerto de entrada para ordenar productos en base a criterios dinámicos.
 */
public interface SortProductUseCase {

    /**
     * Ordena productos según los pesos especificados para cada criterio.
     *
     * @param salesWeight peso del criterio de ventas por unidades
     * @param stockRatioWeight peso del criterio de ratio de stock
     * @return lista ordenada de productos
     */
    List<Product> sortProducts(double salesWeight, double stockRatioWeight);
}
