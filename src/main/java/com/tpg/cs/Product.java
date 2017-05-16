package com.tpg.cs;

public enum Product {
    Apple(35), Banana(20), Melon(50), Lime(15);

    private final int price;

    Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
