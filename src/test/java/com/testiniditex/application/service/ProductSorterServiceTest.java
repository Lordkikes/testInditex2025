package com.testiniditex.application.service;

import com.testiniditex.domain.model.Product;
import com.testiniditex.domain.port.input.SortProductUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ProductSorterServiceTest {
    private ProductSorterService productSorterService;

    @Mock
    private SortProductUseCase sortProductUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productSorterService = new ProductSorterService(sortProductUseCase);
    }

    @Test
    void testSortProductsWithValidWeights() {
        // Arrange
        double salesWeight = 0.7;
        double stockRatioWeight = 0.3;
        List<Product> mockProducts = List.of(
                new Product(1, "Product A", 100, null),
                new Product(2, "Product B", 50, null)
        );
        when(sortProductUseCase.sortProducts(salesWeight, stockRatioWeight)).thenReturn(mockProducts);

        // Act
        List<Product> sortedProducts = productSorterService.sort(salesWeight, stockRatioWeight);

        // Assert
        assertEquals(mockProducts, sortedProducts);
        verify(sortProductUseCase, times(1)).sortProducts(salesWeight, stockRatioWeight);
    }

    @Test
    void testSortProductsWithEmptyList() {
        // Arrange
        double salesWeight = 0.5;
        double stockRatioWeight = 0.5;
        when(sortProductUseCase.sortProducts(salesWeight, stockRatioWeight)).thenReturn(List.of());

        // Act
        List<Product> sortedProducts = productSorterService.sort(salesWeight, stockRatioWeight);

        // Assert
        assertEquals(0, sortedProducts.size());
        verify(sortProductUseCase, times(1)).sortProducts(salesWeight, stockRatioWeight);
    }
}