-- Tabla de productos
CREATE TABLE IF NOT EXISTS products (
                                        id INT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    sales_units INT NOT NULL
    );

-- Tabla de stock por talla
CREATE TABLE IF NOT EXISTS product_stock (
                                             product_id INT,
                                             size VARCHAR(5),
    quantity INT,
    PRIMARY KEY (product_id, size),
    FOREIGN KEY (product_id) REFERENCES products(id)
    );

-- Insertar productos
INSERT INTO products (id, name, sales_units) VALUES
                                                 (1, 'V-NECH BASIC SHIRT', 100),
                                                 (2, 'CONTRASTING FABRIC T-SHIRT', 50),
                                                 (3, 'RAISED PRINT T-SHIRT', 80),
                                                 (4, 'PLEATED T-SHIRT', 3),
                                                 (5, 'CONTRASTING LACE T-SHIRT', 650),
                                                 (6, 'SLOGAN T-SHIRT', 20);

-- Insertar stock por talla
INSERT INTO product_stock (product_id, size, quantity) VALUES
                                                           (1, 'S', 4), (1, 'M', 9), (1, 'L', 0),
                                                           (2, 'S', 35), (2, 'M', 9), (2, 'L', 9),
                                                           (3, 'S', 20), (3, 'M', 2), (3, 'L', 20),
                                                           (4, 'S', 25), (4, 'M', 30), (4, 'L', 10),
                                                           (5, 'S', 0), (5, 'M', 1), (5, 'L', 0),
                                                           (6, 'S', 9), (6, 'M', 2), (6, 'L', 5);
