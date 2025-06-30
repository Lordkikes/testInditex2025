package com.testiniditex.application.service;

import com.testiniditex.domain.model.Product;
import com.testiniditex.domain.port.input.SortProductUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSorterService {

    private final SortProductUseCase sortProductUseCase;

    public ProductSorterService(SortProductUseCase sortProductUseCase) {
        this.sortProductUseCase = sortProductUseCase;
    }

    /**
     * Ordena los productos en base a los pesos recibidos.
     *
     * @param salesWeight peso del criterio de ventas por unidades
     * @param stockRatioWeight peso del criterio de ratio de stock
     * @return lista ordenada de productos
     */
    public List<Product> sort(double salesWeight, double stockRatioWeight) {
        return sortProductUseCase.sortProducts(salesWeight, stockRatioWeight);
    }
}
