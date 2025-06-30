package com.testiniditex.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import com.testiniditex.domain.model.Product;
import com.testiniditex.domain.port.output.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SortProductServiceImplTest {

    private SortProductServiceImpl sortProductService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sortProductService = new SortProductServiceImpl(productRepository);
    }

    @Test
    void testSortProductsWithValidWeights() {
        // Arrange
        double salesWeight = 0.7;
        double stockRatioWeight = 0.3;
        List<Product> mockProducts = List.of(
                new Product(1, "Product A", 100, Map.of("S", 4, "M", 0, "L", 3)),
                new Product(2, "Product B", 50, Map.of("S", 2, "M", 1, "L", 0))
        );
        when(productRepository.findAll()).thenReturn(mockProducts);

        // Act
        List<Product> sortedProducts = sortProductService.sortProducts(salesWeight, stockRatioWeight);

        // Assert
        assertEquals(2, sortedProducts.size());
        assertEquals("Product A", sortedProducts.get(0).getName());
        assertEquals("Product B", sortedProducts.get(1).getName());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testSortProductsWithEmptyProductList() {
        // Arrange
        double salesWeight = 0.5;
        double stockRatioWeight = 0.5;
        when(productRepository.findAll()).thenReturn(List.of());

        // Act
        List<Product> sortedProducts = sortProductService.sortProducts(salesWeight, stockRatioWeight);

        // Assert
        assertEquals(0, sortedProducts.size());
        verify(productRepository, times(1)).findAll();
    }
}