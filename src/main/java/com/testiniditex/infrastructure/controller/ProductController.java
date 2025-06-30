package com.testiniditex.infrastructure.controller;

import com.testiniditex.application.service.ProductSorterService;
import com.testiniditex.domain.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Sorting API", description = "Permite ordenar productos por criterios ponderados")
public class ProductController {
    private final ProductSorterService productSorterService;

    public ProductController(ProductSorterService productSorterService) {
        this.productSorterService = productSorterService;
    }

    @Operation(
            summary = "Ordena productos según pesos de ventas y stock",
            description = "Devuelve una lista de productos ordenados según los pesos proporcionados para las ventas y el ratio de stock.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de productos ordenados correctamente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Product.class),
                                    examples = @ExampleObject(
                                            value = "[{\"id\":1,\"name\":\"Product A\",\"salesUnits\":100,\"stockBySize\":{\"S\":10,\"M\":5}}, {\"id\":2,\"name\":\"Product B\",\"salesUnits\":200,\"stockBySize\":{\"L\":20}}]"
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Parámetros inválidos proporcionados",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(
                                            value = "{\"error\":\"Invalid parameters\"}"
                                    )
                            )
                    )
            }
    )
    @GetMapping("/sorted")
    public ResponseEntity<List<Product>> getSortedProducts(
            @RequestParam @Schema(description = "Peso para las ventas", example = "0.7") double salesWeight,
            @RequestParam @Schema(description = "Peso para el ratio de stock", example = "0.3") double stockRatioWeight) {

        List<Product> sortedProducts = productSorterService.sort(salesWeight, stockRatioWeight);
        return ResponseEntity.ok(sortedProducts);
    }
}