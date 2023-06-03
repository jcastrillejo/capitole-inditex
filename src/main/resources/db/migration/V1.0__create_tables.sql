CREATE TABLE IF NOT EXISTS cadena (
    brand_id INT,
    cadena VARCHAR(255) NOT NULL,
    CONSTRAINT "PK_CADENA" PRIMARY KEY (brand_id)
);

CREATE TABLE IF NOT EXISTS h_prices (
    price_list SMALLINT NOT NULL,
    brand_id INT NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    product_id INT NOT NULL,
    priority SMALLINT NOT NULL,
    price FLOAT NOT NULL,
    curr VARCHAR(3) NOT NULL,
    CONSTRAINT "PK_CADENA_PRICES" PRIMARY KEY (price_list),
    CONSTRAINT "FK_CADENA" FOREIGN KEY (brand_id) REFERENCES cadena (brand_id)
);