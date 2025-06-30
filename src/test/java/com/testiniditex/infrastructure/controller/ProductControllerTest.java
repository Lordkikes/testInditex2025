package com.testiniditex.infrastructure.controller;

import com.testiniditex.application.service.ProductSorterService;
import com.testiniditex.domain.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    private ProductController productController;

    @Mock
    private ProductSorterService productSorterService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productController = new ProductController(productSorterService);
    }

    @Test
    void testGetSortedProductsWithValidWeights() {
        // Arrange
        double salesWeight = 0.7;
        double stockRatioWeight = 0.3;
        List<Product> mockProducts = List.of(
                new Product(1, "Product A", 100, null),
                new Product(2, "Product B", 50, null)
        );
        when(productSorterService.sort(salesWeight, stockRatioWeight)).thenReturn(mockProducts);

        // Act
        ResponseEntity<List<Product>> response = productController.getSortedProducts(salesWeight, stockRatioWeight);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockProducts, response.getBody());
        verify(productSorterService, times(1)).sort(salesWeight, stockRatioWeight);
    }

    @Test
    void testGetSortedProductsWithEmptyList() {
        // Arrange
        double salesWeight = 0.5;
        double stockRatioWeight = 0.5;
        when(productSorterService.sort(salesWeight, stockRatioWeight)).thenReturn(List.of());

        // Act
        ResponseEntity<List<Product>> response = productController.getSortedProducts(salesWeight, stockRatioWeight);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
        verify(productSorterService, times(1)).sort(salesWeight, stockRatioWeight);
    }
}