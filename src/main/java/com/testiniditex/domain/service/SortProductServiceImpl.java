
package com.testiniditex.domain.service;

import com.testiniditex.domain.model.Product;
import com.testiniditex.domain.port.input.SortProductUseCase;
import com.testiniditex.domain.port.output.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SortProductServiceImpl implements SortProductUseCase {
    private final ProductRepository productRepository;

    public SortProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Ordena productos consultados desde base de datos,
     * utilizando los pesos dados para cada criterio.
     */
    @Override
    public List<Product> sortProducts(double salesWeight, double stockRatioWeight) {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .sorted(Comparator.comparingDouble(p ->
                        -(salesWeight * p.getSalesUnits() + stockRatioWeight * p.getStockRatio())))
                .toList();
    }

}
