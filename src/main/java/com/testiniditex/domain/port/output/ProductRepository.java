package com.testiniditex.domain.port.output;

import com.testiniditex.domain.model.Product;

import java.util.List;

public interface ProductRepository {

    /**
     * Recupera todos los productos disponibles.
     * @return lista de productos
     */
    List<Product> findAll();
}