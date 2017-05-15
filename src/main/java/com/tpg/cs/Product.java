package com.tpg.cs;

import java.math.BigDecimal;

public enum Product {
    Apple(35), Banana(20), Melon(50);

    private final BigDecimal price;

    Product(Integer price) {
        this.price = new BigDecimal(price);
    }

    public BigDecimal getPrice() {
        return price;
    }
}
